package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;

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
		ArrayList<Book> arr = new ArrayList<Book>();

		BookDA bda = new BookDA();
		Set<Entry<String, Book>> set = bda.getBookMap().entrySet();
		for (Entry<String, Book> entry : set) {
			Book book = entry.getValue();
			if (book.getIsbn().contains(value) || book.getTitle().contains(value) || book.getAuthor().contains(value)|| book.getPublisher().contains(value)) {
				arr.add(book);
			}
		}
		return arr;
	}

	public Book get(String isbn) {
		BookDA bda = new BookDA();
		return bda.get(isbn);
	}

}
