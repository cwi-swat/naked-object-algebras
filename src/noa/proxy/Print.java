package noa.proxy;

import java.lang.reflect.Proxy;

public class Print {
	
	public static class Printed {
		public final String printed;

		Printed(String x) {
			this.printed = x;
		}
		
		@Override
		public String toString() {
			return printed;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T create(Class<T> ialg) {
		return (T) Proxy.newProxyInstance(ialg.getClassLoader(), new Class<?>[] { ialg },
				(x, m, args) -> {
					String s = m.getName() + "(";
					boolean first = true;
					for (Object arg: args) {
						if (!first) {
							s += ", "; 
						}
						if (arg instanceof String) {
							s += "\"" + arg + "\"";
						}
						else {
							s += arg;
						}
						first = false;
					}
					s += ")";
					return new Printed(s);
				});
	}


}
