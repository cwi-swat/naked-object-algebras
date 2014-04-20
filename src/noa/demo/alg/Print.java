package noa.demo.alg;

import java.util.List;

public class Print implements ExpAlg<IPrint, IPrint> {

	@Override
	public IPrint add(IPrint l, IPrint r) {
		return new IPrint() {

			@Override
			public String print() {
				return l.print() + " + " + r.print();
			}
		};
	}

	@Override
	public IPrint lit(int n) {
		return new IPrint() {

			@Override
			public String print() {
				return "" + n;
			}
		};
	}

	@Override
	public IPrint start(IPrint e) {
		return new IPrint() {

			@Override
			public String print() {
				return e.print();
			}
		};
	}

	@Override
	public IPrint list(List<IPrint> es) {
		return new IPrint() {

			@Override
			public String print() {
				String s = "[";
				for (IPrint e : es) {
					s += e.print();
					s += ", ";
				}
				if (!s.equals("[")) {
					s = s.substring(0, s.length() - 2);
				}
				s += "]";
				return s;
			}
		};
	}

	@Override
	public IPrint mul(IPrint l, IPrint r) {
		return new IPrint() {

			@Override
			public String print() {
				return l.print() + " * " + r.print();
			}
		};
	}

}
