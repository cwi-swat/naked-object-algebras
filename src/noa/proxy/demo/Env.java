package noa.proxy.demo;

public class Env<K, V>  {

	public static final <K, V> Env<K,V> empty() {
		return new Env<>();
	}
	
	private final Env<K, V> parent;
	private final K k;
	private final V v;

	private Env() {
		this(null, null, null);
	}
	
	Env(Env<K, V> parent, K k, V v) {
		this.parent = parent;
		this.k = k;
		this.v = v;
	}
	
	public V get(K k) {
		if (k.equals(this.k)) {
			return this.v;
		}
		if (parent != null) {
			return parent.get(k);
		}
		return null;
	}

	public Env<K, V> bind(K k, V v) {
		return new Env<>(this, k, v);
	}
	
}
