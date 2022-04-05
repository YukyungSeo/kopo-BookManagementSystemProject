package kr.ac.kopo.service;

import java.util.ArrayList;

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
		return this.get(id) != null;
	}

	public User remove(User e) {
		return this.remove(e.getId());
	}

	public User remove(String id) {
		UserDA uda = new UserDA();
		return uda.remove(id);
	}

	public ArrayList<User> search(String value) {
		UserDA uda = new UserDA();
		return uda.getList(value);
	}

	public User get(String id) {
		UserDA uda = new UserDA();
		return uda.get(id);
	}

}
