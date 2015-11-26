package noa.proxy.demo;

public interface EvalArith extends ArithAlg<IEval> {

	@Override
	default IEval lit(int n) {
		return () -> n;
	}
	
	@Override
	default IEval add(IEval l, IEval r) {
		return () -> l.eval() + r.eval();
	}
}
