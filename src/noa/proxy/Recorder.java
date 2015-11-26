package noa.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public final class Recorder {

	@SuppressWarnings("unchecked")
	public static <T> T create(Class<T> alg) {
		return (T) Proxy.newProxyInstance(alg.getClassLoader(),new Class[]{alg},
				(x, m, args) -> new Recorder(m, args));
	}
			
	private Method method;
	private Object[] args;

	
	private Recorder(Method method, Object[] args){
		this.method = method;
		this.args = args;		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T build(Object algebra) {
		try {
			Object[] builtArgs = new Object[args.length];
			for (int i = 0; i < args.length; i++) {
				builtArgs[i] = buildArgument(args[i], algebra);
			}
			return (T)method.invoke(algebra, builtArgs);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	private static Object buildArgument(Object arg, Object algebra) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (arg instanceof List<?>){
			return buildList((List<?>) arg, algebra);
		}
		if (arg instanceof Recorder){
			return buildObject((Recorder) arg, algebra);
		}
		return arg;
	}

	private static Object buildObject(Recorder arg, Object algebra) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return arg.build(algebra);
	}

	private static List<Object> buildList(List<?> argList, Object algebra) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Object> args = new ArrayList<Object>();
		for (Object arg : argList){
			if (arg instanceof Recorder){
				args.add(buildObject((Recorder)arg, algebra));
			}
			else {
				args.add(arg);
			}
		}
		return args;
	}


}
