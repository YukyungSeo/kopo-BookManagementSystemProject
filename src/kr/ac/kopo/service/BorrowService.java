package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import kr.ac.kopo.controller.ErrorType;
import kr.ac.kopo.da.inFile.BookDA;
import kr.ac.kopo.da.inFile.BorrowDA;
import kr.ac.kopo.model.Book;
import kr.ac.kopo.model.Borrow;

public class BorrowService {

	private BookDA bookda = new BookDA();
	private BorrowDA bda = new BorrowDA();
	
	public ErrorType borrowBook(String isbn, String userId) {

		if (!bookda.containISBN(isbn)) { // 해당 ISBN이 없어면 false
			return ErrorType.NOTEXIST;
		}

		if (bda.containISBN(isbn)) { // 대여 중이면 false
			return ErrorType.BORROWED;
		}

		Book book = bookda.get(isbn);
		book.setBorrow(true);
		bookda.add(book.getIsbn(), book);

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 7); // 7일을 더해준다. 대여일 7일

		boolean bool = bda.add(isbn, new Borrow(isbn, book.getTitle(), userId, new Date(), c.getTime()));
		return bool ? ErrorType.SUCCESS : ErrorType.FAIL;
	}

	public ErrorType returnBook(String isbn, String userId) {

		if (!bda.containISBN(isbn)) {
			return ErrorType.NOTEXIST;
		}

		Borrow borrow = bda.get(isbn);
		if (!borrow.getUserId().equals(userId)) {
			return ErrorType.NOTEXIST;
		}

		Book book = bookda.get(isbn);
		book.setBorrow(false);
		bookda.add(book.getIsbn(), book);

		return bda.remove(isbn) != null ? ErrorType.SUCCESS : ErrorType.FAIL;
	}
	
	public boolean containISBN(String isbn) {
		return this.getBorrow(isbn) != null;
	}

	public ArrayList<Borrow> searchBorrow(String Value) {
		return bda.getList(Value);
	}

	public ArrayList<Borrow> searchBorrowWithID(String userId) {
		return bda.getListWithID(userId);
	}

	public Borrow getBorrow(String isbn) {
		return bda.get(isbn);
	}
}
