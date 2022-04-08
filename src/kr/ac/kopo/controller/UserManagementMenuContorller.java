package kr.ac.kopo.controller;

import kr.ac.kopo.service.UserService;
import kr.ac.kopo.util.PrintListUtil;

public class UserManagementMenuContorller extends AccountMenuController implements MenuController {

	@Override
	public void process() {
		
		PBU.boundaryOfMenuStart();
		IO.println(" < 관리자 page - 회원 관리 page 입니다. >");
		int selection = IO.getInt("항목을 선택하세요(1.회원등록 2.회원삭제 3.회원검색 4.관리자승인 5.이전메뉴) : ");
		switch (selection) {
		case 1:
			this.addUser();
			break;
		case 2:
			this.removeUser();
			break;
		case 3:
			this.searchUser();
			break;
		case 4:
			managerApproval();
			break;
		case 5:
			break;
		default:
			IO.println("항목이 존재하지 않습니다. 이전 메뉴로 돌아갑니다.");
			break;
		}
		PBU.boundaryOfMenuEnd();
	}

	private void addUser() {
		AccountController ac = new AccountController();
		int num = IO.getInt("등록하실 회원 수를 입력하세요 : ");
		for (int i = 0; i < num; i++) {
			IO.println((i + 1) + "번째 회원 등록");
			ac.join();
		}
	}

	private void removeUser() {
		UserService us = new UserService();
		int num = IO.getInt("삭제하실 회원 수를 입력하세요 : ");
		for (int i = 0; i < num; i++) {
			String id = IO.getString((i + 1) + "번째 아이디 : ");
			if(!us.containID(id))
				IO.println("해당 아이디가 존재하지 않습니다.");
			us.removeUser(id);
		}
	}

	private void searchUser() {
		UserService us = new UserService();
		PrintListUtil pu = new PrintListUtil();

		String value = IO.getString("검색어 : ");
		pu.printUserList(us.searchUser(value));
	}

	private void managerApproval() {
		// TODO 관리자 대기 승인
	}

}
