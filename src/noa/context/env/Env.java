package noa.context.env;

public interface Env<K,V> {
	V get(K k);
	Env<K,V> bind(K k, V v);
}
