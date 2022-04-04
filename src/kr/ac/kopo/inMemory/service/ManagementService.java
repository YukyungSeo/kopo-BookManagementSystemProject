package kr.ac.kopo.inMemory.service;

import java.util.ArrayList;

import kr.ac.kopo.inMemory.da.AccountDA;
import kr.ac.kopo.inMemory.da.BookDA;
import kr.ac.kopo.inMemory.da.BorrowDA;
import kr.ac.kopo.inMemory.model.User;

public interface ManagementService<E> {

	public static final AccountDA ACCOUNTDA = new AccountDA();
	public static final BookDA BOOKDA = new BookDA();
	public static final BorrowDA BORROWDA = new BorrowDA();
	
	public boolean add(E e);
	public User remove(E e);
	public ArrayList<E> search(String value);
	
}
