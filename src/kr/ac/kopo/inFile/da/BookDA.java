package kr.ac.kopo.inFile.da;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.util.FileReadWrite;

public class BookDA implements MapDA<String, Book> {

	private static Map<String, Book> BOOKMAP;

	@SuppressWarnings("unchecked")
	public BookDA() {
		super();
		BookDA.BOOKMAP = (Map<String, Book>) FileReadWrite.read("book");
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
		boolean bool = BOOKMAP.put(k, v) == null;
		FileReadWrite.write("book", BookDA.BOOKMAP);
		return bool;
	}

	@Override
	public Book remove(String k) {
		Book book = BookDA.BOOKMAP.remove(k);
		FileReadWrite.write("book", BookDA.BOOKMAP);
		return book;
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
