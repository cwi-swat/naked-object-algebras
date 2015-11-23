package noa.ctx.env;

import java.util.function.Supplier;

public class Reader<E> {
	private static class Stack<E> {
		private final E value;
		private final Stack<E> prev;

		Stack(Stack<E> prev, E value) {
			this.prev = prev;
			this.value = value;
		}
	}
	
	private Stack<E> stack;
	
	public Reader(E init) {
		this.stack = new Stack<E>(null, init);
	}
	
	public <T> Supplier<T> cc(Supplier<T> k) {
		Stack<E> snapshot = reify();
		return () -> restore(snapshot, k);
	}
	
	private Stack<E> reify() {
		return stack;
	}
	
	private <T> T restore(Stack<E> snapshot, Supplier<T> f) {
		this.stack = snapshot;
		return f.get();
	}
	
	
	public E ask() {
		return stack.value;
	}
	
	public <T> T local(E e, Supplier<T> f) {
		try {
			stack = new Stack<>(stack, e);
			return f.get();
		}
		finally {
			stack = stack.prev;;
		}
	}

}
