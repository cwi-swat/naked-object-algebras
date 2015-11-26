package noa.proxy;

import java.lang.reflect.Proxy;

public class ToString {
	@SuppressWarnings("unchecked")
	public static <T, U> T create(Class<T> ialg, Class<U> type, T alg) {
		return (T) Proxy.newProxyInstance(ialg.getClassLoader(), new Class<?>[] { ialg },
				(x, m, args) -> {
					Object target = m.invoke(alg, args);
					return Proxy.newProxyInstance(ialg.getClassLoader(), new Class<?>[] {type},
							(y, m2, args2) -> {
								if (m2.getName().equals("toString")) {
									String s = m.getName() + "(";
									boolean first = true;
									for (Object arg: args) {
										if (!first) {
											s += ", ";
										}
										s += arg;
										first = false;
									}
									return s + ")";
								}
								return m2.invoke(target, args2);
							});
				});
	}

}
