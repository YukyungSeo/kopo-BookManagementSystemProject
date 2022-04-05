package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.Set;
import java.util.Map.Entry;

import kr.ac.kopo.da.UserDA;
import kr.ac.kopo.model.User;

public class UserService {

	public boolean join(User e) {
		UserDA uda = new UserDA();
		return uda.add(e.getId(), e);
	}

	public boolean isUser(User e) {
		User user = this.get(e.getId());
		if (user.getPassword().equals(e.getPassword()))
			return true;
		return false;
	}

	public boolean containID(String id) {
		// TODO Auto-generated method stub
		UserDA uda = new UserDA();
		return uda.get(id) != null;
	}

	public boolean login(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean logout(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	public User remove(User e) {
		return this.remove(e.getId());
	}

	public User remove(String id) {
		UserDA uda = new UserDA();
		return uda.remove(id);
	}

	public ArrayList<User> search(String value) {
		ArrayList<User> arr = new ArrayList<User>();
		
		UserDA uda = new UserDA();
		Set<Entry<String, User>> set = uda.getAccountMap().entrySet();
		for (Entry<String, User> entry : set) {
			User user = entry.getValue();
			if(user.getId().contains(value) || user.getName().contains(value)) {
				arr.add(user);
			}
		}
		return arr;
	}

	public User get(User e) {
		// TODO Auto-generated method stub
		return null;
	}

	public User get(String id) {
		UserDA uda = new UserDA();
		return uda.get(id);
	}

}
