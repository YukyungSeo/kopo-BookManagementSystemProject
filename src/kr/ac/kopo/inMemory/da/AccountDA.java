package kr.ac.kopo.inMemory.da;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.inMemory.model.User;

public class AccountDA implements MapDA<String, User> {

	private Map<String, User> accountMap;

	public AccountDA() {
		super();
		this.accountMap = new HashMap<>();
	}

	public AccountDA(Map<String, User> accountMap) {
		super();
		this.accountMap = accountMap;
	}

	public Map<String, User> getAccountMap() {
		return accountMap;
	}

	public void setAccountMap(Map<String, User> accountMap) {
		this.accountMap = accountMap;
	}

	@Override
	public boolean add(String k, User v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User remove(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(String k) {
		return accountMap.get(k);
	}

	@Override
	public ArrayList<User> getAll(String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
