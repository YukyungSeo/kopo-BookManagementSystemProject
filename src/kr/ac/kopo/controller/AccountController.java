package kr.ac.kopo.controller;

import kr.ac.kopo.model.Manager;
import kr.ac.kopo.model.User;
import kr.ac.kopo.service.UserService;

public class AccountController implements Controller {

	protected void signup() {
		UserService us = new UserService();

		char c = IO.getChar("관리자인가요?(y/n) : ");

		String id = this.getId(us);
		String pwd = IO.getString("패스워드 : ");
		String pwd2 = IO.getString("패스워드 재입력 : ");
		String name = IO.getString("이름 : ");
		String birth = IO.getString("생년월일(ex.1990.01.01) : ");
		String email = IO.getString("이메일 : ");
		String phoneNumber = IO.getString("전화번호 : ");

		ErrorType et = null;
		if (c == 'y' || c == 'Y') {
			et = us.addUser(new Manager(id, pwd, name, birth, email, phoneNumber), pwd2);
		} else {
			et = us.addUser(new User(id, pwd, name, birth, email, phoneNumber), pwd2);
		}

		switch (et) {
		case NOTEQUALPWD:
			IO.println("비밀번호가 일치하지 않습니다. 회원가입에 실패하셨습니다.");
			break;
		case OUTOFFORM:
			IO.println("비밀번호가 공백입니다. 회원가입에 실패하셨습니다.");
		case SUCCESS:
			IO.println("회원가입이 완료되었습니다.");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + et);
		}

	}

	private String getId(UserService us) {
		String id = null;
		loop: while (true) {
			id = IO.getString("아이디 : ");
			ErrorType et = us.checkId(id);

			switch (et) {
			case OUTOFFORM:
				IO.println("아이디가 공백입니다. 다시 입력해주세요.");
				break;
			case EXIST:
				IO.println("이미 존재하는 아이디입니다. 다시 입력해주세요.");
				break;
			case SUCCESS:
				break loop;
			default:
				throw new IllegalArgumentException("Unexpected value: " + et);
			}
		}
		return id;
	}

	protected User login() {
		String id = IO.getString("아이디 : ");
		String pwd = IO.getString("패스워드 : ");

		UserService us = new UserService();
		User user = us.getUser(id, pwd);
		if (user == null) {
			IO.println("입력하신 정보가 맞지 않습니다.");
			return null;
		}

		return user;
	}

	// TODO 회원탈퇴
//	protected User resign() {
//		String id = IO.getString("아이디 : ");
//		String pwd = IO.getString("패스워드 : ");
//
//		UserService us = new UserService();
//		User user = us.removeUser(id, pwd);
//
//		if (user == null) {
//			IO.println("입력하신 정보가 맞지 않습니다.");
//			return null;
//		}
//
//		return user;
//	}

}
