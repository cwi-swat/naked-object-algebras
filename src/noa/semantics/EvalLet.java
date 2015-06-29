package noa.semantics;

import java.util.function.Supplier;

public class EvalLet<V extends EnvAlg<Supplier<Integer>,Integer>> 
  extends EvalExp<V> implements LetAlg<Supplier<Integer>> {

	@Override
	public Supplier<Integer> var(String x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier<Integer> let(String x, Supplier<Integer> value,
			Supplier<Integer> body) {
		// TODO Auto-generated method stub
		return null;
	}

}
