package noa.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public final class Propagate  {
	/*
	 * create: F[(*A) => V] => F[(*A, B) => V]
	 * 
	 *  (*A) => V: (functional) interface source
	 *  (*A, B) => V: (functional) interface target
	 *  f: Algebra interface F over S
	 *  alg: F, the concrete algebra 
	 */
	
	@SuppressWarnings("unchecked")
	public static <F, S, T> F create(Class<F> f, Class<S> source, Class<T> target, F alg) {
		return (F) Proxy.newProxyInstance(f.getClassLoader(), new Class<?>[] {f}, 
				new Lifter<>(source, target, alg));
	}

	
	private static class Lifter<S, T, F> implements InvocationHandler {
		private final Class<S> source;
		private final Class<T> target;
		private final F alg;
		
		private Lifter(Class<S> s, Class<T> t, F alg) {
			this.source = s;
			this.target = t;
			this.alg = alg;
		}
		
		@Override
		public Object invoke(Object proxy, Method constructor, Object[] kids) throws Throwable {
			return proxy(target, 
					(p, extEval, args) -> { 
						// get the base interpreter from alg
						Object evaluator = constructor.invoke(alg, lower(extEval, kids, args));
						
						if (extEval.getDeclaringClass() != target) {
							// not our concern
							return  extEval.invoke(evaluator, args);
						}

						// obtain the eval method (which has one fewer parameter)
						Method eval = source.getMethod(extEval.getName(), 
								Arrays.copyOf(extEval.getParameterTypes(), args.length - 1));
						
						
						
						// invoke it on the base interpreter ignoring the extra param.
						return eval.invoke(evaluator, Arrays.copyOf(args, args.length - 1));
					});
		}
		
		private Object lower1(Method extEval, Object kid, Object[] extArgs) {
			if (target.isInstance(kid)) {
				return proxy(source, (p, eval, args) -> {
					if (eval.getDeclaringClass() != source) {
						return eval.invoke(kid, args);
					}
					return extEval.invoke(kid, extend(args, last(extArgs)));
				});
			} 
			// todo: deal with lists.
			return kid;
		}
		
		private Object[] lower(Method eval, Object[] kids, Object[] args) {
			Object lowered[] = new Object[kids.length];
			for (int i = 0; i < kids.length; i++) {
				lowered[i] = lower1(eval, kids[i], args);
			}
			return lowered;
		}
		
		@SuppressWarnings("unchecked")
		private static <T> T proxy(Class<T> t, InvocationHandler f) {
			return (T) Proxy.newProxyInstance(t.getClassLoader(), new Class<?>[] { t }, f);
		}
		
		private static Object[] extend(Object[] array, Object ext) {
			if (array == null) {
				return new Object[] { ext };
			}
			Object extArray[] = Arrays.copyOf(array, array.length + 1);
			extArray[array.length] = ext;
			return extArray;
		}
		
		private static Object last(Object[] objs) {
			return objs[objs.length - 1];
		}
		
	}
	
	
}
