package kr.ac.kopo.controller;

import kr.ac.kopo.model.Manager;

public class ManagerMenuController extends UserMenuController {

	public ManagerMenuController(Manager manager) {
		super(manager);
	}

	@Override
	public void process() {

		PBU.boundaryOfMenuStart();
		int selection = -1;
		loop: while (super.getUser() != null && selection != 7) {
			IO.println(" < 관리자 page 입니다. >");
			selection = IO.getInt("항목을 선택하세요(1.마이페이지 2.도서검색 3.도서대여 4.도서반납 5.회원관리 6.도서관리 7.로그아웃) : ");
			switch (selection) {
			case 1:
				super.myPage();
				PBU.boundaryOfWork();
				break;
			case 2:
				super.searchBook();
				PBU.boundaryOfWork();
				break;
			case 3:
				super.borrowBook();
				PBU.boundaryOfWork();
				break;
			case 4:
				super.returnBook();
				PBU.boundaryOfWork();
				break;
			case 5:
				this.userManagement();
				break;
			case 6:
				this.bookManagement();
				break;
			case 7:
				IO.println("로그아웃합니다.");
				break loop;
			default:
				IO.println("항목이 존재하지 않습니다. ");
				break;
			}
		}
		PBU.boundaryOfMenuEnd();

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
