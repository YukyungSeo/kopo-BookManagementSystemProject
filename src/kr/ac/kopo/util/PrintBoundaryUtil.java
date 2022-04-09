package kr.ac.kopo.util;

public class PrintBoundaryUtil {
	
	private ScannerIOUtil su;

	public PrintBoundaryUtil() {
		super();
		this.su = new ScannerIOUtil();
	}

	public PrintBoundaryUtil(ScannerIOUtil su) {
		super();
		this.su = su;
	}

	public void boundaryOfMenuStart() {
		su.println();
		su.println("=========================================================================================================");
		su.println();
	}

	public void boundaryOfMenuEnd() {
		su.println();
		su.println("=========================================================================================================");
		su.println();
	}

	public void boundaryOfWork() {
		su.println();
		su.println("_________________________________________________________________________________________________________");
		su.println();
	}
	
}
