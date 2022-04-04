package kr.ac.kopo.inMemory.service;

import java.util.ArrayList;

import kr.ac.kopo.inMemory.model.User;

public class UserManagementService implements ManagementService<User> {

	public UserManagementService() {
		super();
	}

	@Override
	public boolean add(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User remove(User e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> search(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getAccount(String id) {
		return ManagementService.ACCOUNTDA.get(id);
	}

}
