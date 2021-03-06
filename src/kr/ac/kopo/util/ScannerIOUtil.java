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
		try {
			print(msg);
			return Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			print("잘못입력하셨습니다.");
			return Integer.MIN_VALUE;
		}
	}

	public char getChar(String msg) {
		try {
			print(msg);
			return sc.nextLine().charAt(0);
		} catch (Exception e) {
			println("잘못입력하셨습니다.");
			return '`';
		}
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

	public void println() {
		System.out.println();
	}

}
