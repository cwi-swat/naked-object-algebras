package noa.proxy;

import java.lang.reflect.Proxy;
import java.util.IdentityHashMap;
import java.util.Set;

public class ToDot {
	
	public static class Node {
		private Object obj;
		private String label;

		Node(String label, Object obj) {
			this.label = label;
			this.obj = obj;
		}

		String getId() {
			return "node" + System.identityHashCode(obj);
		}
		
		@Override
		public int hashCode() {
			return (getId() + getLabel()).hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Node)) {
				return false;
			}
			return ((Node)obj).getId().equals(getId()) && ((Node)obj).getLabel().equals(getLabel());
		}
		
		public String getLabel() {
			return label;
		}
		
		@Override
		public String toString() {
			return getId() + " [label=\"" + getLabel() + "\"]";
		}
	
	}
	
	public static class Edge {
		private Node from;
		private Node to;
		private String label;

		public Edge(String label, Node from, Node to) {
			this.label = label;
			this.from = from;
			this.to = to;
		}
		
		@Override
		public String toString() {
			return from.getId() + " -> " + to.getId() + " [label=\"" + label + "\"]";
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Edge)) {
				return false;
			}
			Edge e = (Edge)obj;
			return e.from.equals(from) && e.to.equals(to) && e.label.equals(label);
		}
		
		@Override
		public int hashCode() {
			return (from.getId() + to.getId() + label).hashCode();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T create(Class<T> ialg, T alg, IdentityHashMap<Object, Node> nodes, Set<Edge> edges) {
		return (T) Proxy.newProxyInstance(ialg.getClassLoader(), new Class<?>[] { ialg },
				(x, m, args) -> {
					Object result = m.invoke(alg, args);
					if (!nodes.containsKey(result)) {
						nodes.put(result, new Node(m.getName(), result));
					}
					if (args == null) {
						return result;
					}
					int i = 0;
					for (Object arg: args) {
						Node to = null;
						if (nodes.containsKey(arg)) {
							to = nodes.get(arg); // an "object"
						}
						else {
							Object key = new Object();
							to = new Node(arg.toString(), key);
							nodes.put(key,  to);
						}
						String label = m.getParameters()[i].getName();
//						System.out.println(nodes);
//						System.out.println(result + " -> " + arg);
						edges.add(new Edge(label, nodes.get(result), to));
						i++;
					}
					return result;
				});
	}

	
}
