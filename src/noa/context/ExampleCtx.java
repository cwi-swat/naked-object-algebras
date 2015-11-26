package noa.context;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Supplier;

import noa.context.env.ArrayDequeReader;
import noa.context.env.Env;
import noa.context.env.Reader;
import noa.context.env.WithEnv;
import noa.context.state.Cell;
import noa.context.state.WithStore;

interface ArithAlg<E> {
	E add(E l, E r);
	E lit(int n);
}

interface LetAlg<E> {
	E let(String x, E e, E b);
	E var(String x);
}

interface LamAlg<E> {
	E lam(String x, E e);
	E apply(E f, E a);
}

interface SeqAlg<E> {
	E create();
	E assign(E x, E v);
	E block(List<E> es);
}

interface EvalArith extends ArithAlg<Supplier<Object>> {
	@Override
	default Supplier<Object> add(Supplier<Object> l, Supplier<Object> r) {
		return () -> {
			return ((Integer)l.get()) + ((Integer)r.get());
		};
	}

	@Override
	default Supplier<Object> lit(int n) {
		return () -> n;
	}
}


interface EvalLet extends LetAlg<Supplier<Object>>, WithEnv<String, Object> {
	
	
	@Override
	default Supplier<Object> let(String x, Supplier<Object> e, Supplier<Object> b) {
		return () -> local(askEnv().bind(x, e.get()), b); 
	}

	@Override
	default Supplier<Object> var(String x) {
		return () -> askEnv().get(x);
	}
}

interface EvalLetStore extends LetAlg<Supplier<Object>>, WithEnv<String, Object>, WithStore {
	
	@Override
	default Supplier<Object> let(String x, Supplier<Object> e, Supplier<Object> b) {
		return () -> {
			Cell c = new Cell();
			return local(askEnv().bind(x, c), 
					() -> modify(askStore().__put(c, e.get()), b)); 
		};
	}

	@Override
	default Supplier<Object> var(String x) {
		return () -> askStore().get((Cell)askEnv().get(x));
	}
}

interface EvalLam extends LamAlg<Supplier<Object>>, WithEnv<String, Object> {
	@Override
	default Supplier<Object> lam(String x, Supplier<Object> e) {
		return () -> {
			Env<String,Object> lex = askEnv();
			Function<Object, Object> f = (Object a) -> local(lex.bind(x, a), e);
			return f;
		};
	}
	
	@SuppressWarnings("unchecked")
	@Override
	default Supplier<Object> apply(Supplier<Object> f, Supplier<Object> a) {
		return () -> ((Function<Object,Object>)f.get()).apply(a.get());
	}
}

interface EvalSeq extends SeqAlg<Supplier<Object>>, WithStore {
	@Override
	default Supplier<Object> assign(Supplier<Object> x, Supplier<Object> v) {
		return () -> update((Cell)x.get(), v.get());
	}
	
	@Override
	default Supplier<Object> create() {
		Cell c = new Cell();
		return () -> modify(askStore().__put(c, 0), () -> c);
	}
	
	@Override
	default Supplier<Object> block(List<Supplier<Object>> es) {
		return () -> {
			Object result = null;
			for (Supplier<Object> e: es) {
				result = e.get();
			}
			return result;
		};
	}
}


class MyEnv<K, V> implements Env<K, V> {

	public static final <K, V> MyEnv<K,V> empty() {
		return new MyEnv<>();
	}
	
	private final MyEnv<K, V> parent;
	private final K k;
	private final V v;

	private MyEnv() {
		this(null, null, null);
	}
	
	MyEnv(MyEnv<K, V> parent, K k, V v) {
		this.parent = parent;
		this.k = k;
		this.v = v;
	}
	
	@Override
	public V get(K k) {
		if (k.equals(this.k)) {
			return this.v;
		}
		if (parent != null) {
			return parent.get(k);
		}
		return null;
	}

	@Override
	public Env<K, V> bind(K k, V v) {
		return new MyEnv<>(this, k, v);
	}
	
}


public class ExampleCtx implements EvalArith, EvalLet, EvalLam, EvalSeq {
	public static void main(String[] args) {
		ExampleCtx eval = new ExampleCtx();
		Supplier<Object> f =
				eval.let("c", eval.create(),
						eval.block(Arrays.asList(
								eval.assign(eval.create(), eval.lit(10)),
								eval.assign(eval.var("c"), 
										eval.apply(eval.lam("x", eval.add(eval.var("x"), eval.var("x"))), eval.lit(2))),
								eval.assign(eval.var("c"), eval.lit(12))
								)));
		System.out.println(f.get());
		Iterator<Entry<Cell, Object>> iter = eval.askStore().entryIterator();
		while (iter.hasNext()) {
			Map.Entry<Cell, Object> entry = iter.next();
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		
	}

	private ArrayDequeReader<Env<String,Object>> envReader;

	public ExampleCtx() {
		this.envReader = new ArrayDequeReader<Env<String, Object>>(MyEnv.empty());
	}
	
	@Override
	public Reader<Env<String, Object>> envReader() {
		return envReader;
	}


}

