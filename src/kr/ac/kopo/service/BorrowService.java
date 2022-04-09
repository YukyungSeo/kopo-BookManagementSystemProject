package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import kr.ac.kopo.controller.ErrorType;
//import kr.ac.kopo.inMemory.da.BookDA;
//import kr.ac.kopo.inMemory.da.BorrowDA;
import kr.ac.kopo.inFile.da.BookDA;
import kr.ac.kopo.inFile.da.BorrowDA;
import kr.ac.kopo.model.Book;
import kr.ac.kopo.model.Borrow;

public class BorrowService {

	public ErrorType borrowBook(String isbn, String userId) {
		// TODO 안되는 이유 각각 출력 (예외처리)
		BookDA bookda = new BookDA();
		BorrowDA bda = new BorrowDA();

		if (!bookda.containISBN(isbn)) { // 해당 ISBN이 없어면 false
			return ErrorType.NOEXIST;
		}

		if (bda.containISBN(isbn)) { // 대여 중이면 false
			return ErrorType.BORROWED;
		}

		Book book = bookda.get(isbn);
		book.setBorrow(true);
		bookda.saveData();

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 7); // 7일을 더해준다. 대여일 7일

		bda.add(isbn, new Borrow(isbn, book.getTitle(), userId, new Date(), c.getTime()));
		return ErrorType.SUCCESS;
	}

	public ErrorType returnBook(String isbn, String userId) {
		BookDA bookda = new BookDA();
		BorrowDA bda = new BorrowDA();
		if (!bda.containISBN(isbn)) {
			return ErrorType.NOEXIST;
		}

		Borrow borrow = bda.get(isbn);
		if (!borrow.getUserId().equals(userId)) {
			return ErrorType.NOEXIST;
		}

		Book book = bookda.get(isbn);
		book.setBorrow(false);
		bookda.saveData();

		bda.remove(isbn);
		return ErrorType.SUCCESS;
	}
	
	public boolean containISBN(String isbn) {
		return this.getBorrow(isbn) != null;
	}

	public ArrayList<Borrow> searchBorrow(String Value) {
		BorrowDA bda = new BorrowDA();
		return bda.getList(Value);
	}

	public ArrayList<Borrow> searchBorrowWithID(String userId) {
		BorrowDA bda = new BorrowDA();
		return bda.getListWithID(userId);
	}

	public Borrow getBorrow(String isbn) {
		BorrowDA bda = new BorrowDA();
		return bda.get(isbn);
	}
}
