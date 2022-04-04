package kr.ac.kopo.inMemory.model;

public class Member extends User {

	public Member() {
		super();
	}

	public Member(String id, String password, String name, String birth, String email, String phoneNumber) {
		super(id, password, name, birth, email, phoneNumber);
	}

}
