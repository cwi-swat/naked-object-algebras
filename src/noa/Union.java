package noa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Union implements InvocationHandler {

	private Object[] algs;

	private Union(Object[] algs) {
		this.algs = algs;
	}

	@SuppressWarnings("unchecked")
	public static <T> T union(Class<T> algInterface, Object ...algs) {
		return (T) Proxy.newProxyInstance(algInterface.getClassLoader(), new Class<?>[] { algInterface },
				new Union(algs));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		for (Object alg: algs) {
			try {
				return method.invoke(alg, args);
			}
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				continue;
			}
		}
		throw new UnsupportedOperationException("method was not found in algebras: " + method.getName() + "/" + method.getParameterCount());
	}
	
}
