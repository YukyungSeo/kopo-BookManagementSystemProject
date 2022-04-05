package kr.ac.kopo.controller;

import kr.ac.kopo.service.UserService;
import kr.ac.kopo.util.PrintLibrarySystemListUtil;

public class UserManagementMenuContorller extends AccountMenuController implements MenuController {

	@Override
	public void process() {
		IO.println(" < 회원 관리 page 입니다. >");
		int selection = IO.getInt("항목을 선택하세요(1.회원등록 2.회원삭제 3.회원검색 4.관리자승인) : ");
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
		default:
			IO.println("항목이 존재하지 않습니다.");
			break;
		}
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
			us.remove(id);
		}
	}

	private void searchUser() {
		UserService us = new UserService();
		PrintLibrarySystemListUtil pu = new PrintLibrarySystemListUtil();

		String value = IO.getString("검색어 : ");
		pu.printUserList(us.search(value));
	}

	private void managerApproval() {
		// TODO 관리자 대기 승인
	}

}
