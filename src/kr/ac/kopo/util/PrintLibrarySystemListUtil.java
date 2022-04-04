package kr.ac.kopo.util;

import java.util.ArrayList;

import kr.ac.kopo.inMemory.model.Book;
import kr.ac.kopo.inMemory.model.User;

public class PrintLibrarySystemListUtil extends ScannerIOUtil {
	
	//TODO
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

	public PrintLibrarySystemListUtil() {
		super();
	}

	public void printUserList(ArrayList<User> list) {
		
		println("< 회원 목록 >");
		println("--------------------------------------------------------------------------------------------");
		println("\t아이디\t패스워드\t이름\t생년월일\t\te-mail\t\t\t전화번호");
		for (User user : list) {
			println("--------------------------------------------------------------------------------------------");
			println(String.format("\t%s\t%s\t%s\t%s\t%s\t%s", user.getId(), user.getPassword(), user.getName(),
					user.getBirth(), user.getEmail(), user.getPhoneNumber()));
		}
		println("--------------------------------------------------------------------------------------------");

	}

	public void printBookList(ArrayList<Book> list) {

		println("< 도서 목록 >");
		println("--------------------------------------------------------------------------------------------");
		println("\tISBN\t제목\t\t지은이\t출판사\t\t대여여부");
		//TODO:String.format으로 열간격 맟추기
		for (Book book : list) {
			println("--------------------------------------------------------------------------------------------");
			println(String.format("\t%s\t%s\t%s\t%s\t%s", book.getIsbn(), book.getTitle(), book.getAuthor(),
					book.getPublisher(), book.isBorrow() ? "대여 중" : "대여 가능"));
		}
		println("--------------------------------------------------------------------------------------------");

	}
	
//	public void printBorrowList(ArrayList<Borrow> list) {
//		//TODO:대여 정보 출력	
//	}
}
