package noa.demo;

import noa.Builder;
import noa.demo.alg.Eval;
import noa.demo.alg.ExpAlg;
import noa.demo.alg.IEval;
import noa.demo.alg.IPrint;
import noa.demo.alg.Print;
import noa.demo.syn.DemoLexer;
import noa.demo.syn.DemoParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Demo {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <X> X parse(String s, ExpAlg alg)  {
		DemoLexer lexer = new DemoLexer(new ANTLRInputStream(s));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    DemoParser parser = new DemoParser(tokens);
	    parser.setBuilder(alg);
		return (X) parser.p()._p;
	}

	private static void testBuilder(String src) {
		System.out.println("## Using builder");
		Builder builder = parse(src, Builder.builderBuilder(ExpAlg.class));
		IEval eval = builder.build(new Eval());
		System.out.println("eval " + src + " = " + eval.eval());
		
		IPrint print = builder.build(new Print());
		System.out.println("print " + src + " = " + print.print());
	}
	
	private static void testParse(String src) {
		System.out.println("## Using algebras directly");
		IEval eval = parse(src, new Eval());
		System.out.println("eval " + src + " = " + eval.eval());
		
		IPrint print = parse(src, new Print());
		System.out.println("print" + src + " = " + print.print());
	}
	
	public static void main(String[] args) {
		testBuilder("1 + 2 * 3 ");
		testBuilder("avg(1,2,3)");
		testParse("1 + 2 * 3 ");
		testParse("avg(1,2,3)");
	}
}
