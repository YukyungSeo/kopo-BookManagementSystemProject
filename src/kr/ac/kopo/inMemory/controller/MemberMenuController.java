package kr.ac.kopo.inMemory.controller;

import kr.ac.kopo.inMemory.model.Member;

public class MemberMenuController implements MenuController {

	Member member;

	public MemberMenuController() {
		super();
	}

	public MemberMenuController(Member member) {
		super();
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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
