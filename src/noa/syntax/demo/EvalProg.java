package noa.syntax.demo;

public class EvalProg implements ProgAlg<IEval, IEval> {
	
	@Override
	public IEval start(IEval e) {
		return e;
	}
}
