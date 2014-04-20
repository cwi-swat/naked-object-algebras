package noa.demo.alg;

import java.util.List;

import noa.annos.Syntax;

public interface ExpAlg<P, E> {
	
	// needed because apparently ANTLR4 does not allow calling
	// left-recursive rules directly (?)
	@Syntax("_")
	P start(E e);
	
	@Syntax("_ '+' _")
	E add(E l, E r);
	
	@Syntax("NUM")
	E lit(int n);
	
	@Syntax("'[' _@','+ ']'")
	E list(List<E> es);
}
