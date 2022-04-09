package kr.ac.kopo.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.model.Borrow;
import kr.ac.kopo.model.User;

public class PrintListUtil {

	private ScannerIOUtil su;

	public PrintListUtil() {
		super();
		this.su = new ScannerIOUtil();
	}

	public PrintListUtil(ScannerIOUtil su) {
		super();
		this.su = su;
	}

	public void printUserList(ArrayList<User> list) {

		su.println("< 회원 목록 >");
		su.println("--------------------------------------------------------------------------------------------");
		su.println("\t아이디\t패스워드\t이름\t생년월일\t\te-mail\t\t\t전화번호");
		for (User user : list) {
			su.println("--------------------------------------------------------------------------------------------");
			su.println(String.format("\t%s\t%s\t%s\t%s\t%s\t%s", user.getId(), user.getPassword(), user.getName(),
					user.getBirth(), user.getEmail(), user.getPhoneNumber()));
		}
		su.println("--------------------------------------------------------------------------------------------");

	}

	public void printUserInfo(User user) {

		su.println("< 회원 정보 >");
		su.println("--------------------------------------------------------------------------------------------");
		su.println("\t아이디\t패스워드\t이름\t생년월일\t\te-mail\t\t\t전화번호");
		su.println("--------------------------------------------------------------------------------------------");
		su.println(String.format("\t%s\t%s\t%s\t%s\t%s\t%s", user.getId(), user.getPassword(), user.getName(),
				user.getBirth(), user.getEmail(), user.getPhoneNumber()));
		su.println("--------------------------------------------------------------------------------------------");

	}

	public void printBookList(ArrayList<Book> list) {

		su.println("< 도서 목록 >");
		su.println("--------------------------------------------------------------------------------------------");
		su.println("\tISBN\t제목\t\t지은이\t출판사\t\t대여여부");
		// TODO:String.format으로 열간격 맟추기
		for (Book book : list) {
			su.println("--------------------------------------------------------------------------------------------");
			su.println(String.format("\t%s\t%s\t%s\t%s\t%s", book.getIsbn(), book.getTitle(), book.getAuthor(),
					book.getPublisher(), book.isBorrow() ? "대여 중" : "대여 가능"));
		}
		su.println("--------------------------------------------------------------------------------------------");

	}

	public void printBorrowList(ArrayList<Borrow> list) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Calendar bc = Calendar.getInstance();
		Calendar rc = Calendar.getInstance();

		su.println("< 대여 목록 >");
		su.println("--------------------------------------------------------------------------------------------");
		su.println("\tISBN\t도서제목\t대여자ID\t대여일\t반납일\t");
		// TODO:String.format으로 열간격 맟추기
		for (Borrow borrow : list) {
			bc.setTime(borrow.getBorrowDate());
			rc.setTime(borrow.getReturnDate());

			su.println("--------------------------------------------------------------------------------------------");
			su.println(String.format("\t%s\t%s\t%s\t%s\t%s", borrow.getIsbn(), borrow.getTitle(), borrow.getUserId(),
					sdf.format(bc.getTime()), sdf.format(rc.getTime())));
		}
		su.println("--------------------------------------------------------------------------------------------");
	}
}
