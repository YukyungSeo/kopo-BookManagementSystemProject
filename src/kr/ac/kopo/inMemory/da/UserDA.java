package kr.ac.kopo.inMemory.da;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import kr.ac.kopo.model.User;

public class UserDA implements MapDA<String, User> {

	private final static Map<String, User> USERMAP = new HashMap<>();

	public UserDA() {
		super();
	}

	public Map<String, User> getUSERMAP() {
		return USERMAP;
	}

	@Override
	public boolean add(String k, User v) {
		return USERMAP.put(k, v) == null;
	}

	@Override
	public User remove(String k) {
		return USERMAP.remove(k);
	}

	@Override
	public User get(String k) {
		return USERMAP.get(k);
	}

	@Override
	public ArrayList<User> getList(String value) {
		ArrayList<User> arr = new ArrayList<User>();

		Set<Entry<String, User>> set = this.getUSERMAP().entrySet();
		for (Entry<String, User> entry : set) {
			User user = entry.getValue();
			if (user.getId().contains(value) || user.getName().contains(value) || user.getBirth().contains(value)
					|| user.getEmail().contains(value) || user.getPhoneNumber().contains(value)) {
				arr.add(user);
			}
		}
		return arr;
	}

}
