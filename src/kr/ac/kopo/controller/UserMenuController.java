package kr.ac.kopo.controller;

import kr.ac.kopo.model.User;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.util.PrintLibrarySystemListUtil;

public class UserMenuController implements MenuController {

	private User user;

	public UserMenuController() {
		super();
	}

	public UserMenuController(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		IO.println(" < 일반회원 page 입니다. >");
		int selection = -1;
		while (selection != 7) {
			selection = IO.getInt("항목을 선택하세요(1.마이페이지 2.도서검색 3.도서대여 4.도서반납 5.로그아웃) : ");
			switch (selection) {
			case 1:
				this.myPage();
				break;
			case 2:
				this.searchBook();
				break;
			case 3:
				this.borrowBook();
				break;
			case 4:
				this.returnBook();
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

	protected void myPage() {
		// TODO Auto-generated method stub

	}

	protected void searchBook() {
		BookService bs = new BookService();
		PrintLibrarySystemListUtil pu = new PrintLibrarySystemListUtil();

		String value = IO.getString("검색어 : ");
		pu.printBookList(bs.search(value));
	}

	protected void borrowBook() {
		// TODO Auto-generated method stub

	}

	protected void returnBook() {
		// TODO Auto-generated method stub

	}

}
