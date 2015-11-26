package noa.context.state;

import java.util.function.Supplier;

public class State<S> {
	private S state;
	
	public State(S init) {
		this.state = init;
	}
	
	public S ask() {
		return state;
	}
	
	public <T> T modify(S s, Supplier<T> f) {
		this.state = s;
		return f.get();
	}

}