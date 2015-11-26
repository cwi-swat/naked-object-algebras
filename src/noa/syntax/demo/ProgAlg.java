package noa.syntax.demo;

import noa.syntax.Syntax;

public interface ProgAlg<P, E> {
	@Syntax("prog = exp")
	P start(E e);
}
