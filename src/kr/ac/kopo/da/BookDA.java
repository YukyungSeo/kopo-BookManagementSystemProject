package kr.ac.kopo.da;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.model.Book;

public class BookDA implements MapDA<String, Book> {

	private final static Map<String, Book> bookMap = new HashMap<>();

	public BookDA() {
		super();
	}

	public BookDA(Map<String, Book> bookMap) {
		super();
	}

	public Map<String, Book> getBookMap() {
		return bookMap;
	}

	@Override
	public boolean add(String k, Book v) {
		return bookMap.put(k, v) == null;
	}

	@Override
	public Book remove(String k) {
		return bookMap.remove(k);
	}

	@Override
	public Book get(String k) {
		return bookMap.get(k);
	}

	@Override
	public ArrayList<Book> getAll(String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
