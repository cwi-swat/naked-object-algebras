package noa.demo;

import noa.Builder;
import noa.demo.alg.EvalExp;
import noa.demo.alg.EvalProg;
import noa.demo.alg.IEval;
import noa.demo.alg.IPrint;
import noa.demo.alg.PrintExp;
import noa.demo.alg.PrintProg;
import noa.demo.syn.AllAlg;
import noa.demo.syn.DemoLexer;
import noa.demo.syn.DemoParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Demo {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <X> X parse(String s, AllAlg alg)  {
		DemoLexer lexer = new DemoLexer(new ANTLRInputStream(s));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    DemoParser parser = new DemoParser(tokens);
	    parser.setBuilder(alg);
		return (X) parser.prog()._prog;
	}

	private static void testBuilder(String src) {
		System.out.println("## Using builder");
		Builder builder = parse(src, Builder.builderBuilder(AllAlg.class));
		IEval eval = builder.build(new EvalExp(), new EvalProg());
		System.out.println("eval " + src + " = " + eval.eval());
		
		IPrint print = builder.build(new PrintExp(), new PrintProg());
		System.out.println("print " + src + " = " + print.print());
	}
	
	public static void main(String[] args) {
		testBuilder("1 + 2 * 3 ");
		testBuilder("avg(1,2,3)");
	}
}
