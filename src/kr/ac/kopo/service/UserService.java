package kr.ac.kopo.service;

import java.util.ArrayList;

import kr.ac.kopo.inMemory.da.UserDA;
import kr.ac.kopo.model.User;

public class UserService {

	public boolean join(User e) {
		UserDA uda = new UserDA();
		return uda.add(e.getId(), e);
	}
	
	public boolean checkId(String id) {
		if(id.equals(""))
			return false;
		return true;
	}

	public boolean isUser(User e) {
		User user = this.getUser(e.getId());
		if (user.getPassword().equals(e.getPassword()))
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
		UserDA uda = new UserDA();
		return uda.remove(id);
	}

	public ArrayList<User> searchUser(String value) {
		UserDA uda = new UserDA();
		return uda.getList(value);
	}

	public User getUser(String id) {
		UserDA uda = new UserDA();
		return uda.get(id);
	}

}