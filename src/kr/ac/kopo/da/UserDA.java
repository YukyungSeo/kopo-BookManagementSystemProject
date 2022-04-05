package kr.ac.kopo.da;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.model.User;

public class UserDA implements MapDA<String, User> {

	private final static Map<String, User> accountMap = new HashMap<>();

	public UserDA() {
		super();
	}

	public Map<String, User> getAccountMap() {
		return accountMap;
	}

	@Override
	public boolean add(String k, User v) {
		return accountMap.put(k, v) == null;
	}

	@Override
	public User remove(String k) {
		return accountMap.remove(k);
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
