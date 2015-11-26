package noa.context.env;

import java.util.ArrayDeque;
import java.util.function.Supplier;

public class ArrayDequeReader<E> implements Reader<E> {
	private ArrayDeque<E> stack;
	
	public ArrayDequeReader(E init) {
		stack = new ArrayDeque<>();
		stack.push(init);
	}

	@Override
	public E ask() {
		return stack.peek();
	}

	@Override
	public <T> T local(E e, Supplier<T> f) {
		try {
			stack.push(e);
			return f.get();
		}
		finally {
			stack.pop();
		}
	}

}
