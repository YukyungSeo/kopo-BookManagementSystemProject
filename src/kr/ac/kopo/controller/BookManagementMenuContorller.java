package kr.ac.kopo.controller;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.service.BookService;

public class BookManagementMenuContorller implements MenuController {

	@Override
	public void process() {
		IO.println(" < 도서 관리 입니다. >");
		int selection = IO.getInt("항목을 선택하세요(1.도서등록 2.도서삭제) : ");
		switch (selection) {
		case 1:
			this.addBook();
			break;
		case 2:
			this.removeBook();
			break;
		default:
			IO.println("항목이 존재하지 않습니다.");
			break;
		}
	}

	private void addBook() {
		BookService bs = new BookService();

		int num = IO.getInt("등록하실 도서 수를 입력하세요 : ");
		for (int i = 0; i < num; i++) {
			IO.println((i + 1) + "번째 도서 등록");
			// TODO: 각 입력 조건이 맞는지 확인(ex.제목 저자 출판사가 ""일 경우 등)
			String isbn = this.getIsbn(bs);
			String title = IO.getString("제목 : ");
			String author = IO.getString("저자 : ");
			String publisher = IO.getString("출판사 : ");
			boolean isBorrow = false;

			Book book = new Book(isbn, title, author, publisher, isBorrow);

			if (bs.add(book))
				IO.println("[" + isbn + ":" + title + "] 도서를 추가하였습니다.");
		}
	}

	private String getIsbn(BookService bs) {
		String isbn = null;
		while (true) {
			isbn = IO.getString("ISBN : ");

			if (!bs.containISBN(isbn))
				break;

			IO.println("해당 ISBN은 이미 존재합니다. 다시 입력해주세요.");
		}
		return isbn;
	}

	private void removeBook() {
		BookService bs = new BookService();
		int num = IO.getInt("삭제하실 도서 수를 입력하세요 : ");
		for (int i = 0; i < num; i++) {
			String id = IO.getString((i + 1) + "번째 아이디 : ");
			if(bs.remove(id) == null)
				IO.println("해당 ISBN을 가진 도서는 존재하지 않습니다.");
		}
	}

}
