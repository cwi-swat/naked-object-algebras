package noa.proxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sharing {
	
	@SuppressWarnings("unchecked")
	public static <T> T create(Class<T> ialg, T alg) {
		final Map<List<Object>, Object> memo = new HashMap<>();
		return (T) Proxy.newProxyInstance(ialg.getClassLoader(), new Class<?>[] { ialg },
				(x, m, args) -> {
					List<Object> list;
					if (args == null) {
						list = Arrays.asList(m.getName());
					}
					else {
						Object[] arr = Arrays.copyOf(args, args.length + 1);
						for (int i = 0; i < args.length; i++) {
							if (args[i] instanceof Integer || args[i] instanceof String) {
								arr[i] = args[i];
							}
							else {
								arr[i] = System.identityHashCode(args[i]);
							}
						}
						arr[args.length] = m.getName();
						list = Arrays.asList(arr);
					}
//					System.out.println(list);
					if (!memo.containsKey(list)) {
//						System.out.println("Adding");
						memo.put(list, m.invoke(alg, args));
					}
					else {
//						System.out.println("Found it: sharing on " + list);
					}
//					System.out.println("ASSERT " + memo.containsKey(list));
					Object z = memo.get(list);
//					System.out.println("RETURNING: " + z);
					return z;
				});
	}


}
