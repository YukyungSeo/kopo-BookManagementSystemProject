package kr.ac.kopo.service;

import java.util.ArrayList;

import kr.ac.kopo.controller.ErrorType;
//import kr.ac.kopo.inMemory.da.UserDA;
import kr.ac.kopo.inFile.da.UserDA;
import kr.ac.kopo.model.User;

public class UserService {

	private UserDA uda = new UserDA();

	public ErrorType checkId(String id) {
		if (id.equals(""))
			return ErrorType.OUTOFFORM;

		else if (containID(id))
			return ErrorType.EXIST;

		return ErrorType.NOERROR;
	}

	public ErrorType signup(User newUser, String pwd2) {
		if (!newUser.getPassword().equals(pwd2)) {
			return ErrorType.NOTEQUALPWD;
		}
		uda.add(newUser.getId(), newUser);
		return ErrorType.NOERROR;
	}

	public User isUser(String id, String pwd) {
		User user = this.getUser(id);
		if (user != null && user.getPassword().equals(pwd))
			return user;
		return null;
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
