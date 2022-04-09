package kr.ac.kopo.da.inMemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import kr.ac.kopo.model.Book;

public class BookDA implements MapDA<String, Book> {

	private final static Map<String, Book> BOOKMAP = new HashMap<>();

	public BookDA() {
		super();
	}

	public BookDA(Map<String, Book> bookMap) {
		super();
	}

	public Map<String, Book> getBOOKMAP() {
		return BOOKMAP;
	}
	
	public boolean containISBN(String k) {
		return this.get(k) != null;
	}

	@Override
	public boolean add(String k, Book v) {
		return BOOKMAP.put(k, v) == null;
	}

	@Override
	public Book remove(String k) {
		return BOOKMAP.remove(k);
	}

	@Override
	public Book get(String k) {
		return BOOKMAP.get(k);
	}

	@Override
	public ArrayList<Book> getList(String value) {
		ArrayList<Book> arr = new ArrayList<Book>();

		Set<Entry<String, Book>> set = this.getBOOKMAP().entrySet();
		for (Entry<String, Book> entry : set) {
			Book book = entry.getValue();
			if (book.getIsbn().contains(value) || book.getTitle().contains(value) || book.getAuthor().contains(value)
					|| book.getPublisher().contains(value)) {
				arr.add(book);
			}
		}
		return arr;
	}

}
