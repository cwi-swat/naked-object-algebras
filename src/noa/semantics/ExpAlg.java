package noa.semantics;

public interface ExpAlg<E> {
	E lit(int n);
	E add(E l, E r);
}
