package kr.ac.kopo.model;

@SuppressWarnings("serial")
public class Manager extends User {

	public Manager() {
		super();
	}

	public Manager(String id, String password, String name, String birth, String email, String phoneNumber) {
		super(id, password, name, birth, email, phoneNumber);
	}

}
