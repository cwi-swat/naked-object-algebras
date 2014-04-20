package noa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Builder {

	@SuppressWarnings("unchecked")
	public static <T> T builderBuilder(Class<T> alg) {
		return (T) Proxy.newProxyInstance(alg.getClassLoader(),new Class[]{alg},new BuilderHandler());
	}
			
	private static class BuilderHandler implements InvocationHandler {
		@Override
		public Builder invoke(Object proxy, Method method, Object[] args) {
			return new Builder(method, args);
		} 
	}

	private Method method;
	private Object[] args;

	
	private Builder(Method method, Object[] args){
		this.method = method;
		this.args = args;		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T build(Object ...algebras){
		Object[] builtArgs = new Object[args.length];
		for (int i = 0; i < args.length; i++) {
			builtArgs[i] = buildArgument(args[i], algebras);
		}
		return (T) invokeOnAlgebra(Arrays.asList(algebras), builtArgs);
	}

	private Object buildArgument(Object arg, Object ...algebras) {
		if (arg instanceof List<?>){
			return builderToInterfaceList((List<?>) arg, algebras);
		}
		if (arg instanceof Builder){
			return builderToInterface((Builder) arg, algebras);
		}
		return arg;
	}

	private Object builderToInterface(Builder arg, Object ...algebras) {
		return arg.build(algebras);
	}

	private List<Object> builderToInterfaceList(List<?> argList, Object ...algebras) {
		List<Object> args = new ArrayList<Object>();
		for (Object arg : argList){
			if (arg instanceof Builder){
				args.add(builderToInterface((Builder)arg, algebras));
			}
			else {
				args.add(arg);
			}
		}
		return args;
	}

	private Object invokeOnAlgebra(List<Object> algebras, Object[] args) {
		for (Object factory : algebras){
			if (hasMethod(factory)) {
				try {
					return method.invoke(factory, args);
				} 
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					throw new RuntimeException(e);
				}
			}
		}
		throw new UnsupportedOperationException("method was not found in algebras: " + method.getName());
	}

	private boolean hasMethod(Object factory) {
		Method[] methods = factory.getClass().getMethods();
		for (Method m : methods)  {
			// TODO: check argument types too?
			if (m.getName().equals(method.getName()) && m.getParameterCount() == method.getParameterCount()) {
				return true;
			}
		}
		return false;
	}
}
