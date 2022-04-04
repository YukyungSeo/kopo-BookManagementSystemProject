package kr.ac.kopo.inMemory.test;

import java.util.ArrayList;

import kr.ac.kopo.inMemory.model.Book;
import kr.ac.kopo.inMemory.model.User;
import kr.ac.kopo.util.PrintLibrarySystemListUtil;

public class PrintLibrarySystemListUtilTest {

	PrintLibrarySystemListUtil plu = new PrintLibrarySystemListUtil();
	
	public void printUserListTest () {

		ArrayList<User> arr= new ArrayList<>();
		arr.add(new User("syk332", "asdf", "서유경", "1996.03.08", "syk332@naver.com", "010-2609-3796"));
		
		plu.printUserList(arr);
		
	}
	
	public void printBookListTest () {

		ArrayList<Book> arr= new ArrayList<>();
		arr.add(new Book("B1234", "리눅스 프로그래밍", "장석주", "한국폴리텍대학", false));
		
		plu.printBookList(arr);
		
	}
}
