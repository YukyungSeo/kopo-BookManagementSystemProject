package kr.ac.kopo.service;

import java.util.ArrayList;

//import kr.ac.kopo.da.inMemory.UserDA;
import kr.ac.kopo.da.inFile.UserDA;
import kr.ac.kopo.model.User;
import kr.ac.kopo.type.ErrorType;

public class UserService {

	private UserDA uda = new UserDA();

	public boolean isUser(String id, String pwd) {
		User user = this.getUser(id);
		if (user != null && user.getPassword().equals(pwd))
			return true;
		return false;
	}

	public ErrorType modifyPwd(User user, String nerPwd1, String newPwd2) {
		if (!nerPwd1.equals(newPwd2))
			return ErrorType.NOTEQUALPWD;

		user.setPassword(nerPwd1);
		return uda.add(user.getId(), user) ? ErrorType.SUCCESS : ErrorType.FAIL;
	}

	public ErrorType modifyEmail(User user, String newEmail) {
		user.setEmail(newEmail);
		return uda.add(user.getId(), user) ? ErrorType.SUCCESS : ErrorType.FAIL;
	}

	public ErrorType modifyPhoneNumber(User user, String newPhoneNumber) {
		user.setPhoneNumber(newPhoneNumber);
		return uda.add(user.getId(), user) ? ErrorType.SUCCESS : ErrorType.FAIL;
	}

	public ErrorType loginCheckId(String newId) {
		if (newId.equals(""))
			return ErrorType.OUTOFFORM;

		else if (containID(newId))
			return ErrorType.EXIST;

		return ErrorType.SUCCESS;
	}

	public boolean containID(String id) {
		return this.getUser(id) != null;
	}

	public ErrorType addUser(User newUser, String pwd2) {
		if (!newUser.getPassword().equals(pwd2)) {
			return ErrorType.NOTEQUALPWD;
		}
		return this.addUser(newUser);
	}

	public ErrorType addUser(User e) {
		return uda.add(e.getId(), e) ? ErrorType.SUCCESS : ErrorType.FAIL;
	}

	public ErrorType removeUser(User e) {
		return this.removeUser(e.getId());
	}

	public ErrorType removeUser(String id) {
		if (!this.containID(id))
			return ErrorType.NOTEXIST;

		BorrowService bs = new BorrowService();
		if (bs.searchBorrowWithID(id).size() != 0)
			return ErrorType.BORROWED;

		return uda.remove(id) != null ? ErrorType.SUCCESS : ErrorType.FAIL;
	}

	public User getUser(String id) {
		return uda.get(id);
	}

	public User getUser(String id, String pwd) {
		User user = this.getUser(id);
		if (user != null && user.getPassword().equals(pwd))
			return user;
		return null;
	}

	public ArrayList<User> searchUser(String value) {
		return uda.getList(value);
	}
}
