package noa.syntax.demo;

import noa.syntax.PGen;

public class DemoPGen {
	
	public static void main(String[] args) {
		PGen pgen = new PGen(Tokens.class, AllAlg.class);
		pgen.generate("Demo", "noa.syntax.demo", "src/noa/syntax/demo/", true);
	}
	
}
