package noa.syntax.demo;

import java.util.List;

public class EvalExp implements ExpAlg<IEval> {

	@Override
	public IEval add(IEval l, IEval r) {
		return () -> l.eval() + r.eval();
	}

	@Override
	public IEval lit(int n) {
		return () -> n;
	}

	@Override
	public IEval avg(List<IEval> es) {
		return () -> es.stream().mapToInt(IEval::eval).sum() / es.size();  
	}

	@Override
	public IEval avg2(List<IEval> es) {
		return () -> es.stream().mapToInt(IEval::eval).sum() / es.size();
	}

	
	@Override
	public IEval mul(IEval l, IEval r) {
		return () -> l.eval() * r.eval();
	}

}
