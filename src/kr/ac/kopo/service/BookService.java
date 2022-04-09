package kr.ac.kopo.service;

import java.util.ArrayList;

import kr.ac.kopo.controller.ErrorType;
//import kr.ac.kopo.inMemory.da.BookDA;
import kr.ac.kopo.inFile.da.BookDA;
import kr.ac.kopo.model.Book;

public class BookService {

	private BookDA bda = new BookDA();

	public BookService() {
		super();
	}

	public ErrorType addBook(Book e) {
		return bda.add(e.getIsbn(), e) ? ErrorType.SUCCESS : ErrorType.FAIL;
	}

	public ErrorType checkISBN(String isbn) {
		if (isbn.equals(""))
			return ErrorType.OUTOFFORM;
		return this.containISBN(isbn) ? ErrorType.EXIST : ErrorType.SUCCESS;
	}

	public boolean containISBN(String isbn) {
		return this.getBook(isbn) != null;
	}

	public ErrorType removeBook(Book e) {
		return this.removeBook(e.getIsbn());
	}

	public ErrorType removeBook(String isbn) {
		// 해당 isbn이 없을 경우 삭제 실패
		if (!this.containISBN(isbn))
			return ErrorType.NOEXIST;

		// 해당 isbn을 가진 도서가 대여중일 경우 삭제 실패
		BorrowService bs = new BorrowService();
		if (bs.containISBN(isbn))
			return ErrorType.BORROWED;

		// 도서 삭제를 성공했을 경우와 실패하여 null값이 반환되는 경우
		return bda.remove(isbn) != null ? ErrorType.SUCCESS : ErrorType.NULL;
	}

	public ArrayList<Book> searchBook(String value) {
		return bda.getList(value);
	}

	public Book getBook(String isbn) {
		return bda.get(isbn);
	}

}
