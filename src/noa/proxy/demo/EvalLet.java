package noa.proxy.demo;

public interface EvalLet extends LetAlg<IEvalEnv> {

	@Override
	default IEvalEnv var(String x) {
		return env -> env.get(x);
	}
	
	@Override
	default IEvalEnv let(String x, IEvalEnv init, IEvalEnv body) {
		return env -> body.eval(env.bind(x, init.eval(env)));
	}
	
}
