package noa.demo.alg;

import java.util.List;

public class Eval implements ExpAlg<IEval, IEval> {

	@Override
	public IEval add(IEval l, IEval r) {
		return new IEval() {
			
			@Override
			public int eval() {
				return l.eval() + r.eval();
			}
		};
	}

	@Override
	public IEval lit(int n) {
		return new IEval() {
			
			@Override
			public int eval() {
				return n;
			}
		};
	}

	@Override
	public IEval start(IEval e) {
		return new IEval() {
			
			@Override
			public int eval() {
				return e.eval();
			}
		};
	}

	@Override
	public IEval list(List<IEval> es) {
		return new IEval() {
			
			@Override
			public int eval() {
				int n = 0;
				for (IEval e: es) {
					n += e.eval();
				}
				return n;
			}
		};
	}

}
