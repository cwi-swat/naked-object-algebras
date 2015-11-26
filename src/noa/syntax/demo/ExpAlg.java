package noa.syntax.demo;

import java.util.List;

import noa.syntax.Level;
import noa.syntax.Syntax;

public interface ExpAlg<E> {

	// Support for precedence annos on infix operators.
	@Syntax("exp = exp '*' exp") @Level(20)
	E mul(E l, E r);

	@Syntax("exp = exp '+' exp") @Level(10)
	E add(E l, E r);


	// Refer to tokens (defined in Tokens.java)
	@Syntax("exp = NUM")
	E lit(int n);
	
	// Special notation for separated lists
	@Syntax("exp = 'avg' '(' exp@','+ ')'")
	E avg(List<E> es);

	// Non separated lists
	@Syntax("exp = 'avg2' '(' exp+ ')'")
	E avg2(List<E> es);

}
