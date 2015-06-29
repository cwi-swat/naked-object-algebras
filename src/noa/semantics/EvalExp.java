package noa.semantics;

import java.util.function.Supplier;

public class EvalExp<V extends CompAlg<Supplier<Integer>, Integer>> implements ExpAlg<Supplier<Integer>> {

	V comp;
	
	@Override
	public Supplier<Integer> lit(int n) {
		return comp.pure( () -> n );
	}

	@Override
	public Supplier<Integer> add(Supplier<Integer> l, Supplier<Integer>  r) {
		return comp.pure(() -> l.get() + r.get());
	}

}
