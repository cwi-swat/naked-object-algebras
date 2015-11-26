package noa.context.state;

public final class Cell {
	@Override
	public String toString() {
		return "@" + System.identityHashCode(this);
	}
}
