package kr.ac.kopo.controller;

import kr.ac.kopo.model.User;

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
		IO.println("일반회원 page 입니다.");
		myPage();
		searchBook();
		borrowBook();
		returnBook();

	}

	protected void myPage() {
		// TODO Auto-generated method stub

	}

	protected void searchBook() {
		// TODO Auto-generated method stub

	}

	protected void borrowBook() {
		// TODO Auto-generated method stub

	}

	protected void returnBook() {
		// TODO Auto-generated method stub

	}

}
