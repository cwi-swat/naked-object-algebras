package noa.context.env;

import java.util.function.Supplier;

public interface WithEnv<K, V> {
	// note: this can not be an abstract method, because than all readers will be the same thing
	// IOW the reader should "interface local"
	//static final LinkedStackReader<ImmutableMap<String, Object>> reader = new LinkedStackReader<>(DefaultTrieMap.of());
	
	// the name of this thing should be unique across all With... things
	// (so: it's actually not *safe*)
	// how to brand it?
	Reader<Env<K, V>> envReader();
	
	default Env<K, V> askEnv() {
		return envReader().ask();
	}
	
	default <T> T local(Env<K, V> env, Supplier<T> f) {
		return envReader().local(env, f);
	}
	
}