package kr.ac.kopo.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Borrow implements Serializable {

	private String isbn;
	private String title;
	private String userId;
	private Date borrowDate;
	private Date returnDate;

	public Borrow() {
		super();
	}

	public Borrow(String isbn, String title, String userId, Date borrowDate, Date returnDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.userId = userId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Borrow [isbn=" + isbn + ", title=" + title + ", userId=" + userId + ", borrowDate=" + borrowDate
				+ ", returnDate=" + returnDate + "]";
	}

}
