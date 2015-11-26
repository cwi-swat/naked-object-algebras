package noa.ctx.env;

import java.util.function.Supplier;

public interface Reader<E> {
	E ask();
	<T> T local(E e, Supplier<T> f);
}
