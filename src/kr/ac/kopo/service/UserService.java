package kr.ac.kopo.service;

import java.util.ArrayList;

//import kr.ac.kopo.inMemory.da.UserDA;
import kr.ac.kopo.inFile.da.UserDA;
import kr.ac.kopo.model.User;

public class UserService {

	private UserDA uda = new UserDA();

	public boolean join(User e) {
		return uda.add(e.getId(), e);
	}

	public boolean checkId(String id) {
		if (id.equals(""))
			return false;
		return true;
	}

	public boolean isUser(User e) {
		User user = this.getUser(e.getId());
		if (user != null && user.getPassword().equals(e.getPassword()))
			return true;
		return false;
	}

	public boolean containID(String id) {
		return this.getUser(id) != null;
	}

	public User removeUser(User e) {
		return this.removeUser(e.getId());
	}

	public User removeUser(String id) {
		return uda.remove(id);
	}

	public ArrayList<User> searchUser(String value) {
		return uda.getList(value);
	}

	public User getUser(String id) {
		return uda.get(id);
	}

}
