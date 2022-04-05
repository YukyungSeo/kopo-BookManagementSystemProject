package kr.ac.kopo.controller;

import kr.ac.kopo.model.Manager;
import kr.ac.kopo.model.User;
import kr.ac.kopo.service.UserService;
import kr.ac.kopo.util.ScannerIOUtil;

public class AccountController {

	private ScannerIOUtil io = new ScannerIOUtil();

	protected boolean join() {
		UserService us = new UserService();

		//TODO: 각 입력 조건이 맞는지 확인(ex.아이디나 비밀번호가 공백일 경우, 생년월일이 맞지 않을 경우 등)
		String id = this.getId(us);
		String pwd = io.getString("패스워드 : ");
		String name = io.getString("이름 : ");
		String birth = io.getString("생년월일(ex.1990.01.01) : ");
		String email = io.getString("이메일 : ");
		String phoneNumber = io.getString("전화번호 : ");
		char c = io.getChar("관리자인가요?(y/n) : ");

		User user;
		if (c == 'y' || c == 'Y') {
			user = new Manager(id, pwd, name, birth, email, phoneNumber);
		} else {
			user = new User(id, pwd, name, birth, email, phoneNumber);
		}

		return us.join(user);
	}

	private String getId(UserService us) {
		String id = null;
		while (true) {
			id = io.getString("아이디 : ");

			if (!us.containID(id))
				break;

			io.println("해당 아이디는 이미 존재합니다. 다시 입력해주세요.");
		}
		return id;
	}

	protected User login() {
		String id = io.getString("아이디 : ");
		String pwd = io.getString("패스워드 : ");

		UserService us = new UserService();
		User user = new User(id, pwd);

		if (!us.isUser(user)) {
			io.println("입력하신 정보가 맞지 않습니다.");
			return null;
		}

		return us.get(id);
	}

	protected User resign() {
		String id = io.getString("아이디 : ");
		String pwd = io.getString("패스워드 : ");

		UserService us = new UserService();
		User user = new User(id, pwd);

		if (!us.isUser(user)) {
			io.println("입력하신 정보가 맞지 않습니다.");
			return null;
		}

		return us.remove(user);
	}

}
