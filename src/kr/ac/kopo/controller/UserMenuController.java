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
		pu.printBorrowList(bs.searchBorrowWithID(user.getId()));
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
		ErrorType et = bs.borrowBook(isbn, user.getId());

		switch (et) {
		case NOEXIST:
			IO.println("해당 ISBN을 가진 도서는 존재하지않습니다. ISBN을 확인해주세요.");
			break;
		case BORROWED:
			IO.println("이미 대여 중인 도서입니다. 대여에 실패하셨습니다.");
			break;
		case NOERROR:
			IO.println("[ " + isbn + ":" + bs.getBorrow(isbn).getTitle() + " ] 도서가 대여되었습니다.");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + et);
		}

		this.printBorrowList(bs);
	}

	protected void returnBook() {
		BorrowService bs = new BorrowService();

		String isbn = IO.getString("도서 ISBN : ");
		ErrorType et = bs.returnBook(isbn, user.getId());
		switch (et) {
		case NOEXIST:
			IO.println("해당 ISBN을 가진 도서를 대여하지 않았습니다. ISBN을 확인해주세요.");
			break;
		case NOERROR:
			BookService bookservice = new BookService();
			IO.println("[ " + isbn + ":" + bookservice.getBook(isbn).getTitle() + " ] 도서가 반납되었습니다.");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + et);
		}

		this.printBorrowList(bs);
	}

	private void printBorrowList(BorrowService bs) {
		PrintListUtil pu = new PrintListUtil();
		pu.printBorrowList(bs.searchBorrowWithID(user.getId()));
	}

}
