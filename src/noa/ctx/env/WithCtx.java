package noa.ctx.env;

import java.util.function.Supplier;

public interface WithCtx<C extends WithCtx.Ctx> {
	interface Ctx {}
	
	static Reader<Ctx> reader = new Reader<>(null);

	default <V> Supplier<V> cc(Supplier<V> k) {
		return reader.cc(k);
	}

	@SuppressWarnings("unchecked")
	default C askEnv() {
		return (C) reader.ask();
	}

	default <V> V local(C c, Supplier<V> f) {
		return reader.local(c, f);
	}
		
}
