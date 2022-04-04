package kr.ac.kopo.inMemory.da;

import java.util.ArrayList;
import java.util.Map;

public class BorrowDA implements MapDA<String, String> {

	private Map<String, String> borrowMap;

	public BorrowDA() {
		super();
	}

	public BorrowDA(Map<String, String> borrowMap) {
		super();
		this.borrowMap = borrowMap;
	}

	public Map<String, String> getBorrowMap() {
		return borrowMap;
	}

	public void setBorrowMap(Map<String, String> borrowMap) {
		this.borrowMap = borrowMap;
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
