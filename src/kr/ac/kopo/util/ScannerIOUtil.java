package kr.ac.kopo.util;

import java.util.Scanner;

public class ScannerIOUtil {

	private final Scanner sc = new Scanner(System.in);

	public ScannerIOUtil() {
		super();
	}

	public Scanner getSc() {
		return sc;
	}

	public int getInt(String msg) {
		print(msg);
		return Integer.parseInt(sc.nextLine());
	}

	public char getChar(String msg) {
		print(msg);
		return sc.nextLine().charAt(0);
	}

	public String getString(String msg) {
		print(msg);
		return sc.nextLine();
	}

	public void print(String msg) {
		System.out.print(msg);
	}

	public void println(String msg) {
		System.out.println(msg);
	}

}
