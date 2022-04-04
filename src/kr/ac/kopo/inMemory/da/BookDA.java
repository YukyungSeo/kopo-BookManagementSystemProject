package kr.ac.kopo.inMemory.da;

import java.util.ArrayList;
import java.util.Map;

import kr.ac.kopo.inMemory.model.Book;

public class BookDA implements MapDA<String, Book> {

	private Map<String, Book> bookMap;

	public BookDA() {
		super();
	}

	public BookDA(Map<String, Book> bookMap) {
		super();
		this.bookMap = bookMap;
	}

	public Map<String, Book> getBookMap() {
		return bookMap;
	}

	public void setBookMap(Map<String, Book> bookMap) {
		this.bookMap = bookMap;
	}

	@Override
	public boolean add(String k, Book v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book remove(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book get(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> getAll(String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
