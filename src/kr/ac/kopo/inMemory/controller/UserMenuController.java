package kr.ac.kopo.inMemory.controller;

import kr.ac.kopo.inMemory.model.User;

public class UserMenuController implements MenuController {

	User user;

	public UserMenuController() {
		super();
	}

	public UserMenuController(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		myPage();
		searchBook();
		borrowBook();
		returnBook();

	}

	private void myPage() {
		// TODO Auto-generated method stub

	}

	private void searchBook() {
		// TODO Auto-generated method stub

	}

	private void borrowBook() {
		// TODO Auto-generated method stub

	}

	private void returnBook() {
		// TODO Auto-generated method stub

	}

}
