package noa.demo;

import noa.PGen;
import noa.demo.alg.ExpAlg;
import noa.demo.syn.Tokens;

public class DemoPGen {
	
	public static void main(String[] args) {
		PGen pgen = new PGen(Tokens.class, Object.class, ExpAlg.class);
		pgen.generate("Demo", "noa.demo.syn", "src/noa/demo/syn/");
	}
	
}
