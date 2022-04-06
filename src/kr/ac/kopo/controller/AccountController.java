package kr.ac.kopo.controller;

import kr.ac.kopo.model.Manager;
import kr.ac.kopo.model.User;
import kr.ac.kopo.service.UserService;

public class AccountController implements Controller {

	protected boolean join() {
		UserService us = new UserService();

		char c = IO.getChar("관리자인가요?(y/n) : ");

		// TODO: 각 입력 조건이 맞는지 확인(ex.아이디나 비밀번호가 공백일 경우, 생년월일이 맞지 않을 경우 등)
		String id = this.getId(us);
		String pwd = IO.getString("패스워드 : ");
		String name = IO.getString("이름 : ");
		String birth = IO.getString("생년월일(ex.1990.01.01) : ");
		String email = IO.getString("이메일 : ");
		String phoneNumber = IO.getString("전화번호 : ");

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
			id = IO.getString("아이디 : ");

			if (!us.checkId(id))
				IO.println("아이디가 빈 값입니다. 다시 입력해주세요.");
			
			else if (us.containID(id))
				IO.println("해당 아이디는 이미 존재합니다. 다시 입력해주세요.");
			
			else
				break;
		}
		return id;
	}

	protected User login() {
		String id = IO.getString("아이디 : ");
		String pwd = IO.getString("패스워드 : ");

		UserService us = new UserService();
		User user = new User(id, pwd);

		if (!us.isUser(user)) {
			IO.println("입력하신 정보가 맞지 않습니다.");
			return null;
		}

		return us.getUser(id);
	}

	protected User resign() {
		String id = IO.getString("아이디 : ");
		String pwd = IO.getString("패스워드 : ");

		UserService us = new UserService();
		User user = new User(id, pwd);

		if (!us.isUser(user)) {
			IO.println("입력하신 정보가 맞지 않습니다.");
			return null;
		}

		return us.removeUser(user);
	}

}
