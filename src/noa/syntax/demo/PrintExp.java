package noa.syntax.demo;

import java.util.List;

public class PrintExp implements ExpAlg<IPrint> {

	@Override
	public IPrint add(IPrint l, IPrint r) {
		return () -> l.print() + " + " + r.print();
	}

	@Override
	public IPrint lit(int n) {
		return () -> "" + n;
	}

	@Override
	public IPrint avg(List<IPrint> es) {
		return () -> {
			String s = "avg(";
			for (IPrint e : es) {
				s += e.print();
				s += ", ";
			}
			if (!s.equals("avg(")) {
				s = s.substring(0, s.length() - 2);
			}
			s += ")";
			return s;
		};
	}
	
	@Override
	public IPrint avg2(List<IPrint> es) {
		return () -> {
			String s = "avg2(";
			for (IPrint e : es) {
				s += e.print();
				s += " ";
			}
			if (!s.equals("avg2(")) {
				s = s.substring(0, s.length() - 1);
			}
			s += ")";
			return s;
		};
	}


	@Override
	public IPrint mul(IPrint l, IPrint r) {
		return () -> l.print() + " * " + r.print();
	}

}
