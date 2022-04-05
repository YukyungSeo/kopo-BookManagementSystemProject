package kr.ac.kopo.controller;

import kr.ac.kopo.model.Manager;

public class ManagerMenuController extends UserMenuController {

	private Manager manager;

	public ManagerMenuController() {
		super();
	}

	public ManagerMenuController(Manager manager) {
		super();
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void process() {
		IO.println(" < 관리자 page 입니다. >");
		int selection = -1;
		while (selection != 7) {
			selection = IO.getInt("항목을 선택하세요(1.마이페이지 2.도서검색 3.도서대여 4.도서반납 5.회원관리 6.도서관리 7.로그아웃) : ");
			switch (selection) {
			case 1:
				super.myPage();
				break;
			case 2:
				super.searchBook();
				break;
			case 3:
				super.borrowBook();
				break;
			case 4:
				super.returnBook();
				break;
			case 5:
				this.userManagement();
				break;
			case 6:
				this.bookManagement();
				break;
			case 7:
				IO.println("로그아웃합니다.");
				break;
			default:
				IO.println("항목이 존재하지 않습니다.");
				break;
			}
		}

	}

	private void userManagement() {
		UserManagementMenuContorller ummc = new UserManagementMenuContorller();
		ummc.process();
	}

	private void bookManagement() {
		BookManagementMenuContorller bmmc = new BookManagementMenuContorller();
		bmmc.process();
	}

}
