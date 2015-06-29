package noa.semantics;

import java.util.function.Supplier;

public interface CompAlg<E, V> {
	E pure(Supplier<V> func);
}
