package kr.ac.kopo.service;

import java.util.ArrayList;

import kr.ac.kopo.da.BookDA;
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
