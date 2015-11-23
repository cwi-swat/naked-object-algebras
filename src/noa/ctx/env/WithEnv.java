package noa.ctx.env;

import java.util.function.Supplier;

import io.usethesource.capsule.DefaultTrieMap;
import io.usethesource.capsule.ImmutableMap;

public interface WithEnv {
	static Reader<ImmutableMap<String, Object>> reader = new Reader<>(DefaultTrieMap.of());
	
	default <T> Supplier<T>cc(Supplier<T> k) {
		return reader.cc(k);
	}
	
	default ImmutableMap<String, Object> askEnv() {
		return reader.ask();
	}
	
	default <T> T local(ImmutableMap<String, Object> env, Supplier<T> f) {
		return reader.local(env, f);
	}
	
}