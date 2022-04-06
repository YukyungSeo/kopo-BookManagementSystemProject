package kr.ac.kopo.service;

import java.util.ArrayList;

import kr.ac.kopo.inMemory.da.BookDA;
import kr.ac.kopo.model.Book;

public class BookService {

	public BookService() {
		super();
	}

	public boolean add(Book e) {
		BookDA bda = new BookDA();
		return bda.add(e.getIsbn(), e);
	}

	public boolean containISBN(String isbn) {
		return this.get(isbn) != null;
	}

	public Book remove(Book e) {
		// TODO 대여중인 도서를 삭제할 경우 대여정보도 삭제
		return this.remove(e.getIsbn());
	}

	public Book remove(String isbn) {
		BookDA bda = new BookDA();
		return bda.remove(isbn);
	}

	public ArrayList<Book> search(String value) {
		BookDA bda = new BookDA();
		return bda.getList(value);
	}

	public Book get(String isbn) {
		BookDA bda = new BookDA();
		return bda.get(isbn);
	}

}
