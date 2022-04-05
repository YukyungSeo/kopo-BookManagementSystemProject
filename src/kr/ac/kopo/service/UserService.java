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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> search(String value) {
		// TODO Auto-generated method stub
		return null;
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
