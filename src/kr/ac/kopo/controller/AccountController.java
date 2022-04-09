package kr.ac.kopo.controller;

import kr.ac.kopo.model.Manager;
import kr.ac.kopo.model.User;
import kr.ac.kopo.service.UserService;
import kr.ac.kopo.type.ErrorType;

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
			break;
		case FAIL:
			IO.println("회원가입에 실패하셨습니다.");
			break;
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
		} else {
			IO.println("로그인되었습니다.");
			return user;
		}

	}

	protected boolean resign(User user) {
		UserService us = new UserService();
		ErrorType et = us.removeUser(user);

		switch (et) {
		case NOTEXIST:
			IO.println("해당 회원이 존재하지 않습니다.");
			return false;
		case BORROWED:
			IO.println("대여 중인 도서가 있습니다. 탈퇴에 실패하였습니다.");
			return false;
		case FAIL:
			IO.println("탈퇴에 실패하였습니다.");
			return false;
		case SUCCESS:
			IO.println("탈퇴되었습니다. 다시 뵙기를 바랍니다 :)");
			return true;
		default:
			throw new IllegalArgumentException("Unexpected value: " + et);
		}
	}
}
