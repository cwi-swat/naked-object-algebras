package noa.syntax.demo;

import noa.syntax.Skip;
import noa.syntax.Token;

public interface Tokens {
	@Token("[0-9]+")
	static int num(String src) {
		return Integer.parseInt(src);
	}
	
	@Token("[ ]+") @Skip
	void ws();
}
