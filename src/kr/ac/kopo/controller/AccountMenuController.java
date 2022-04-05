package kr.ac.kopo.controller;

import kr.ac.kopo.model.Manager;
import kr.ac.kopo.model.User;
import kr.ac.kopo.service.UserService;

public class AccountMenuController implements MenuController {

	public AccountMenuController() {
		super();
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		IO.println("안녕하세요. 도서관리시스템입니다.");
		int selection = -1;
		while (selection != 3) {
			selection = IO.getInt("항목을 선택하세요(1.회원가입 2.로그인 3.종료) : ");
			switch (selection) {
			case 1:
				if (join())
					IO.println("회원가입이 완료되었습니다");
				else
					IO.print("오류가 발생되었습니다");
				break;
			case 2:
					gotoLoginMenu(login());

					break;
			case 3:
				IO.println("프로그램을 종료합니다.");
				break;
			default:
				IO.println("항목이 존재하지 않습니다.");
				break;
			}
		}
	}

	private boolean join() {
		UserService us = new UserService();

		String id = this.getId(us);
		String pwd = IO.getString("패스워드 : ");
		String name = IO.getString("이름 : ");
		String birth = IO.getString("생년월일(ex.1990.01.01) : ");
		String email = IO.getString("이메일 : ");
		String phoneNumber = IO.getString("전화번호 : ");

		User user;
		// TODO 입력한 값이 null일 경우 예외처리
		char c = IO.getChar("관리자인가요?(y/n) : ");
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

			if (!us.containID(id))
				break;

			IO.println("해당 아이디는 이미 존재합니다. 다시 입력해주세요.");
		}
		return id;
	}

	private User login() {
		// TODO Auto-generated method stub
		String id = IO.getString("아이디 : ");
		String pwd = IO.getString("패스워드 : ");

		UserService us = new UserService();
		User user = us.get(id);

		if (!user.getPassword().equals(pwd)) {
			IO.println("입력정보가 맞지 않습니다.");
			return null;
		}

		IO.println("로그인되었습니다");
		return user;
	}

	private void gotoLoginMenu(User user) {
		
		if (user instanceof Manager) {
			ManagerMenuController mmc = new ManagerMenuController((Manager) user);
			mmc.process();
		} else {
			UserMenuController umc = new UserMenuController(user);
			umc.process();
		}
	}

}
