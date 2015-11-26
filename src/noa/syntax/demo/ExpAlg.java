package noa.syntax.demo;

import java.util.List;

import noa.syntax.Level;
import noa.syntax.Syntax;

public interface ExpAlg<O, I> {

	// Support for precedence annos on infix operators.
	@Syntax("exp = exp '*' exp") @Level(20)
	O mul(I l, I r);

	@Syntax("exp = exp '+' exp") @Level(10)
	O add(I l, I r);


	// Refer to tokens (defined in Tokens.java)
	@Syntax("exp = NUM")
	O lit(int n);
	
	// Special notation for separated lists
	@Syntax("exp = 'avg' '(' exp@','+ ')'")
	O avg(List<I> es);

	// Non separated lists
	@Syntax("exp = 'avg2' '(' exp+ ')'")
	O avg2(List<I> es);

}
