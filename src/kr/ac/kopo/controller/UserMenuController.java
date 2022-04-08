package kr.ac.kopo.controller;

import kr.ac.kopo.model.User;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.service.BorrowService;
import kr.ac.kopo.util.PrintListUtil;

public class UserMenuController implements MenuController {

	private User user;

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
		
		PBU.boundaryOfMenuStart();
		int selection = -1;
		loop: while (selection != 5) {
			IO.println(" < 일반회원 page 입니다. >");
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
			case 5:
				IO.println("로그아웃합니다.");
				break loop;
			default:
				IO.println("항목이 존재하지 않습니다.");
				break;
			}
			PBU.boundaryOfWork();
		}
		PBU.boundaryOfMenuEnd();

	}

	protected void myPage() {
		BorrowService bs = new BorrowService();
		PrintListUtil pu = new PrintListUtil();

		pu.printUserInfo(user);
		pu.printBorrowList(bs.searchBook(user.getId()));
	}

	protected void searchBook() {
		BookService bs = new BookService();
		PrintListUtil pu = new PrintListUtil();

		String value = IO.getString("검색어 : ");
		pu.printBookList(bs.searchBook(value));
	}

	protected void borrowBook() {
		BorrowService bs = new BorrowService();

		String isbn = IO.getString("도서 ISBN : ");
		if (!bs.borrowBook(isbn, user.getId())) {
			IO.println("잘못 입력하셨습니다. ISBN을 확인해주세요.");
		}

		PrintListUtil pu = new PrintListUtil();
		pu.printBorrowList(bs.searchBook(user.getId()));
	}

	protected void returnBook() {
		BorrowService bs = new BorrowService();

		String isbn = IO.getString("도서 ISBN : ");
		if (!bs.returnBook(isbn, user.getId())) {
			IO.println("잘못 입력하셨습니다. ISBN을 확인해주세요.");
		}
		PrintListUtil pu = new PrintListUtil();
		pu.printBorrowList(bs.searchBook(user.getId()));
	}

}
