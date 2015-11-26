package noa.demo;

import noa.demo.syn.AllAlg;
import noa.demo.syn.Tokens;
import noa.syntax.PGen;

public class DemoPGen {
	
	public static void main(String[] args) {
		PGen pgen = new PGen(Tokens.class, AllAlg.class);
		pgen.generate("Demo", "noa.demo.syn", "src/noa/demo/syn/", true);
	}
	
}
