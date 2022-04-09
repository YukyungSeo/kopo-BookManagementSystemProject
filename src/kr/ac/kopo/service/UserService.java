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

		return ErrorType.SUCCESS;
	}

	public ErrorType addUser(User newUser, String pwd2) {
		if (!newUser.getPassword().equals(pwd2)) {
			return ErrorType.NOTEQUALPWD;
		}
		return uda.add(newUser.getId(), newUser) ? ErrorType.SUCCESS : ErrorType.FAIL;
	}

	public User getUser(String id, String pwd) {
		User user = this.getUser(id);
		if (user != null && user.getPassword().equals(pwd))
			return user;
		return null;
	}

	public boolean containID(String id) {
		return this.getUser(id) != null;
	}

	public ErrorType removeUser(User e) {
		return this.removeUser(e.getId());
	}

	public ErrorType removeUser(String id) {
		if(!this.containID(id))
			return ErrorType.NOEXIST;
		return uda.remove(id) != null ? ErrorType.SUCCESS : ErrorType.NULL;		
	}

	public ArrayList<User> searchUser(String value) {
		return uda.getList(value);
	}

	private User getUser(String id) {
		return uda.get(id);
	}

}
