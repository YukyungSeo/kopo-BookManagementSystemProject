package kr.ac.kopo.controller;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.service.BorrowService;
import kr.ac.kopo.type.ErrorType;
import kr.ac.kopo.util.PrintListUtil;

public class BookManagementMenuContorller implements MenuController {

	@Override
	public void process() {
		PBU.boundaryOfMenuStart();
		IO.println(" < 관리자 page - 도서 관리 page 입니다. >");
		int selection = IO.getInt("항목을 선택하세요(1.도서등록 2.도서삭제 3. 대여현황 4.이전메뉴) : ");
		switch (selection) {
		case 1:
			this.addBooks();
			break;
		case 2:
			this.removeBooks();
			break;
		case 3:
			this.borrowStatus();
			break;
		case 4:
			break;
		default:
			IO.println("항목이 존재하지 않습니다. 이전메뉴로 돌아갑니다.");
			break;
		}
		PBU.boundaryOfMenuEnd();
	}

	private void addBooks() {
		int num = IO.getInt("등록하실 도서 수를 입력하세요 : ");
		for (int i = 0; i < num; i++) {
			IO.println((i + 1) + "번째 도서 등록");
			this.addBook();
		}
	}

	private void addBook() {
		BookService bs = new BookService();
		String isbn = this.getIsbn(bs);
		String title = IO.getString("제목 : ");
		String author = IO.getString("저자 : ");
		String publisher = IO.getString("출판사 : ");
		boolean isBorrow = false;

		ErrorType et = bs.addBook(new Book(isbn, title, author, publisher, isBorrow));

		switch (et) {
		case FAIL:
			IO.println("도서등록을 실패하였습니다");
			break;
		case SUCCESS:
			IO.println("[ " + isbn + ":" + title + " ] 도서를 등록하였습니다.");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + et);
		}

	}

	private String getIsbn(BookService bs) {
		String isbn = null;
		loop: while (true) {
			isbn = IO.getString("ISBN : ");
			ErrorType et = bs.addBookCheckISBN(isbn);

			switch (et) {
			case OUTOFFORM:
				IO.println("ISBN이 공백입니다. 다시 입력해주세요.");
				break;
			case EXIST:
				IO.println("이미 존재하는 ISBN입니다. 다시 입력해주세요.");
				break;
			case SUCCESS:
				break loop;
			default:
				throw new IllegalArgumentException("Unexpected value: " + et);
			}

		}
		return isbn;

	}

	private void removeBooks() {
		BookService bs = new BookService();
		int num = IO.getInt("삭제하실 도서 수를 입력하세요 : ");
		for (int i = 0; i < num; i++) {
			String isbn = IO.getString((i + 1) + "번째 ISBN : ");
			ErrorType et = bs.removeBook(isbn);

			switch (et) {
			case NOTEXIST:
				IO.println("해당 ISBN을 가진 도서는 존재하지 않습니다.");
				break;
			case BORROWED:
				IO.println("현재 대여 중인 도서입니다. 도서삭제를 실패하였습니다.");
				break;
			case FAIL:
				IO.println("도서삭제를 실패하였습니다.");
			case SUCCESS:
				IO.println("[ " + isbn + " ] 도서가 삭제되었습니다.");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + et);
			}

		}
	}

	private void borrowStatus() {
		PrintListUtil pu = new PrintListUtil();
		BorrowService bs = new BorrowService();
		pu.printBorrowList(bs.searchBorrow(""));
	}
}
