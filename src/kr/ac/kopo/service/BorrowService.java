package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//import kr.ac.kopo.inMemory.da.BookDA;
//import kr.ac.kopo.inMemory.da.BorrowDA;
import kr.ac.kopo.inFile.da.BookDA;
import kr.ac.kopo.inFile.da.BorrowDA;
import kr.ac.kopo.model.Book;
import kr.ac.kopo.model.Borrow;

public class BorrowService {

	public boolean borrowBook(String isbn, String userId) {
		// TODO 안되는 이유 각각 출력 (예외처리)
		BookDA bookda = new BookDA();
		BorrowDA bda = new BorrowDA();
		if (!bookda.containISBN(isbn)) { // 해당 ISBN이 없어면 false
			return false;
		}
		if(bda.containISBN(isbn)) { // 대여 중이면 false
			return false;
		}
		
		Book book = bookda.get(isbn);
		book.setBorrow(true);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 7);  // 7일을 더해준다.
		
		bda.add(isbn, new Borrow(isbn, book.getTitle(), userId, new Date(), c.getTime()));
		return true;
	}
	
	public boolean returnBook(String isbn, String userId) {
		BookDA bookda = new BookDA();
		BorrowDA bda = new BorrowDA();
		if (!bda.containISBN(isbn)) {
			return false;
		}

		Borrow borrow = bda.get(isbn);
		if(!borrow.getUserId().equals(userId)) {
			return false;
		}
		
		Book book = bookda.get(isbn);
		book.setBorrow(false);
		
		bda.remove(isbn);
		return true;
	}

	public ArrayList<Borrow> searchBook(String userId) {
		BorrowDA bda = new BorrowDA();
		return bda.getListWithID(userId);
	}
}
