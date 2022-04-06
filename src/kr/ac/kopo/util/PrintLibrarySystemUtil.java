package kr.ac.kopo.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.model.Borrow;
import kr.ac.kopo.model.User;

public class PrintLibrarySystemUtil extends ScannerIOUtil {

	// TODO
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

	public PrintLibrarySystemUtil() {
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

	public void printUserInfo(User user) {

		println("< 회원 정보 >");
		println("--------------------------------------------------------------------------------------------");
		println("\t아이디\t패스워드\t이름\t생년월일\t\te-mail\t\t\t전화번호");
		println("--------------------------------------------------------------------------------------------");
		println(String.format("\t%s\t%s\t%s\t%s\t%s\t%s", user.getId(), user.getPassword(), user.getName(),
				user.getBirth(), user.getEmail(), user.getPhoneNumber()));
		println("--------------------------------------------------------------------------------------------");

	}

	public void printBookList(ArrayList<Book> list) {

		println("< 도서 목록 >");
		println("--------------------------------------------------------------------------------------------");
		println("\tISBN\t제목\t\t지은이\t출판사\t\t대여여부");
		// TODO:String.format으로 열간격 맟추기
		for (Book book : list) {
			println("--------------------------------------------------------------------------------------------");
			println(String.format("\t%s\t%s\t%s\t%s\t%s", book.getIsbn(), book.getTitle(), book.getAuthor(),
					book.getPublisher(), book.isBorrow() ? "대여 중" : "대여 가능"));
		}
		println("--------------------------------------------------------------------------------------------");

	}

	public void printBorrowList(ArrayList<Borrow> list) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Calendar bc = Calendar.getInstance();
		Calendar rc = Calendar.getInstance();
		
		println("< 대여 목록 >");
		println("--------------------------------------------------------------------------------------------");
		println("\tISBN\t도서제목\t대여자ID\t대여일\t반납일\t");
		// TODO:String.format으로 열간격 맟추기
		for (Borrow borrow : list) {
			bc.setTime(borrow.getBorrowDate());
			rc.setTime(borrow.getReturnDate());
			
			println("--------------------------------------------------------------------------------------------");
			println(String.format("\t%s\t%s\t%s\t%s\t%s", borrow.getIsbn(), borrow.getTitle(), borrow.getUserId(),
					 sdf.format(bc.getTime()), sdf.format(rc.getTime())));
		}
		println("--------------------------------------------------------------------------------------------");
	}
}
