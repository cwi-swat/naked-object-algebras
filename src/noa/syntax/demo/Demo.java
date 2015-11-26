package noa.syntax.demo;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import noa.proxy.Recorder;
import noa.proxy.Union;

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
		Recorder builder = parse(src, Recorder.create(AllAlg.class));
 		IEval eval = builder.build(Union.union(AllAlg.class, new EvalExp(), new EvalProg()));
		System.out.println("eval " + src + " = " + eval.eval());
		
		IPrint print = builder.build(Union.union(AllAlg.class, new PrintExp(), new PrintProg()));
		System.out.println("print " + src + " = " + print.print());
	}
	
	public static void main(String[] args) {
		testBuilder("1 + 2 * 3 ");
		testBuilder("avg(1,2,3)");
		testBuilder("avg2(1 2 3)");
	}
}
