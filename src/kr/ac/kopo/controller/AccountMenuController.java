package kr.ac.kopo.controller;

import kr.ac.kopo.model.Manager;
import kr.ac.kopo.model.User;

public class AccountMenuController implements MenuController {

	@Override
	public void process() {
		
		PBU.boundaryOfMenuStart();
		int selection = -1;
		while (selection != 3) {
			IO.println("안녕하세요. 도서관리시스템입니다.");
			selection = IO.getInt("항목을 선택하세요(1.회원가입 2.로그인 3.종료) : ");
			switch (selection) {
			case 1:
				this.signup();
				PBU.boundaryOfWork();
				break;
			case 2:
				this.login();
				break;
			case 3:
				IO.println("프로그램을 종료합니다.");
				break;
			default:
				IO.println("항목이 존재하지 않습니다.");
				PBU.boundaryOfWork();
				break;
			}
		}
		PBU.boundaryOfMenuEnd();
		
	}

	private void signup() {
		AccountController ac = new AccountController();
		ac.signup();
	}

	private void login() {
		AccountController ac = new AccountController();
		User user = ac.login();

		if (user != null) {
			IO.println("로그인되었습니다.");
			this.gotoLoginMenu(user);
		} else {
			PBU.boundaryOfWork();
		}
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
