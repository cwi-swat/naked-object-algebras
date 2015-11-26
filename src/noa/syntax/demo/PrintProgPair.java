package noa.syntax.demo;

import noa.proxy.Pair;

public class PrintProgPair implements ProgAlg<IPrint, Pair<IEval, IPrint>> {

	@Override
	public IPrint start(Pair<IEval, IPrint> e) {
		return new IPrint() {
			@Override
			public String print() {
				return "EVAL: " + e.x.eval() + "\n" 
						+ "PRINT: \n" + e.y.print() + "\n";
			}
		};
	}

}
