package noa.syntax.demo;

public class PrintProg implements ProgAlg<IPrint, IPrint> {
	@Override
	public IPrint start(IPrint e) {
		return e;
	}
}
