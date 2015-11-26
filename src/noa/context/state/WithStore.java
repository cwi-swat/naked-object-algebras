package noa.context.state;

import java.util.function.Supplier;

import io.usethesource.capsule.DefaultTrieMap;
import io.usethesource.capsule.ImmutableMap;


@SuppressWarnings("unchecked")
public interface WithStore {
	static State<ImmutableMap<Cell, Object>> state = new State<>(DefaultTrieMap.of());
	
	default <T> ImmutableMap<Cell, T> askStore() {
		return (ImmutableMap<Cell, T>) state.ask();
	}
	
	default <T> T update(Cell c, T v) {
		return (T) modify(askStore().__put(c, v), () -> v);
	}
	
	default <T> T modify(ImmutableMap<Cell, T> store, Supplier<T> f) {
		return state.modify((ImmutableMap<Cell, Object>)store, f);
	}
}
