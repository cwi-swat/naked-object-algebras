package noa.proxy.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Set;

import noa.proxy.Propagate;
import noa.proxy.Print;
import noa.proxy.Sharing;
import noa.proxy.ToDot;
import noa.proxy.ToString;
import noa.proxy.Union;


public class Main {

	static <E, A extends ArithAlg<E> & LetAlg<E>> E exp(A alg) {
		return alg.let("x", alg.lit(2), alg.add(alg.var("x"), alg.var("x")));
	}

	static <E, A extends ArithAlg<E> & LetAlg<E>> E exp2(A alg) {
		return alg.let("x", alg.lit(2), alg.add(alg.var("x"), exp(alg)));
	}

	static <E> E add(ArithAlg<E> alg) {
		return alg.add(alg.lit(1), alg.lit(2));
	}

	interface AllAlg<E> extends ArithAlg<E>, LetAlg<E> {}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		LetAlg<IEvalEnv> evalLet = new EvalLet() { };
		ArithAlg<IEvalEnv> evalArith = Propagate.create(ArithAlg.class, IEval.class, IEvalEnv.class, new EvalArith() {});
		
		IEvalEnv add = add(evalArith);
		System.out.println(add.eval(Env.empty()));
		
		AllAlg<IEvalEnv> eval = ToString.create(AllAlg.class, IEvalEnv.class, Union.union(AllAlg.class, evalLet, evalArith));
		IEvalEnv term = exp(eval);
		System.out.println(term);
		System.out.println(term.eval(Env.empty()));

	
		IEvalEnv term2 = exp2(eval);
		System.out.println(term2.eval(Env.empty()));
		
		IdentityHashMap<Object, ToDot.Node> nodes = new IdentityHashMap<>();
		Set<ToDot.Edge> edges = new HashSet<>();
		exp2(ToDot.create(AllAlg.class, eval, nodes, edges));
		
		try (PrintWriter p = new PrintWriter(new FileWriter(new File("tree.dot")))) {
			p.println("digraph obj {");
			for (ToDot.Node n: nodes.values()) {
				p.println(n + ";");
			}
			for (ToDot.Edge e: edges) {
				p.println(e + ";");
			}
			p.println("}");	
		}
		
		
		nodes.clear();
		edges.clear();
		exp2(ToDot.create(AllAlg.class, Sharing.create(AllAlg.class, eval), nodes, edges));
		
		try (PrintWriter p = new PrintWriter(new FileWriter(new File("dag.dot")))) {
			p.println("digraph obj {");
			for (ToDot.Node n: nodes.values()) {
				p.println(n + ";");
			}
			for (ToDot.Edge e: edges) {
				p.println(e + ";");
			}
			p.println("}");	
		}
		
		Print.Printed printed = exp2(Print.create(AllAlg.class));
		System.out.println(printed);
		
	}
	
}
