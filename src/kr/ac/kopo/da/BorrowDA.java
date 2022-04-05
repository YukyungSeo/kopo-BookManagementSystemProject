package kr.ac.kopo.da;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BorrowDA implements MapDA<String, String> {

	private final static Map<String, String> borrowMap = new HashMap<>();

	public BorrowDA() {
		super();
	}

	public Map<String, String> getBorrowMap() {
		return borrowMap;
	}

	@Override
	public boolean add(String k, String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String remove(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getAll(String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
