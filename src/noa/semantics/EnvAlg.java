package noa.semantics;

import java.util.function.Supplier;

public interface EnvAlg<E, V> extends CompAlg<E, V> {
	E env(Supplier<V> func);
}
