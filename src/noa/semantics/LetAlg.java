package noa.semantics;

public interface LetAlg<E> extends ExpAlg<E> {
	E var(String x);
	E let(String x, E value, E body);
}
