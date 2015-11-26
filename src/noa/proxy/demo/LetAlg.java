package noa.proxy.demo;

public interface LetAlg<E> {
	E let(String x, E init, E body);
	E var(String x);
}
