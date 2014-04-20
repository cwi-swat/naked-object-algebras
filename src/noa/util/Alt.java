package noa.util;

public abstract class Alt implements Comparable<Alt>, Conventions {
	private String nt;
	private int prec;
	private String returnType;
	
	public Alt(String returnType, String nt, int prec) {
		this.returnType = returnType;
		this.nt = nt;
		this.prec = prec;
	}
	
	public int getLevel() {
		return prec;
	}
	
	public String getNT() {
		return nt;
	}
	
	public String returnType() {
		return returnType;
	}

	@Override
	public int compareTo(Alt o) {
		return new Integer(o.getLevel()).compareTo(getLevel());
	}
}
