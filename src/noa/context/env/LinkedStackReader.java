package noa.context.env;

import java.util.function.Supplier;

public class LinkedStackReader<E> implements Reader<E> {

	private static class Stack<E> {
		private final E value;
		private final Stack<E> prev;

		Stack(Stack<E> prev, E value) {
			this.prev = prev;
			this.value = value;
		}
	}
	
	private Stack<E> stack;
	
	public LinkedStackReader(E init) {
		this.stack = new Stack<E>(null, init);
	}
	
	private Stack<E> reify() {
		return stack;
	}
	
	private <T> T restore(Stack<E> snapshot, Supplier<T> f) {
		this.stack = snapshot;
		return f.get();
	}
	
	public <T> Supplier<T> cc(Supplier<T> k) {
		Stack<E> snapshot = reify();
		return () -> restore(snapshot, k);
	}
	
	@Override
	public E ask() {
		return stack.value;
	}
	
	@Override
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
