package kr.ac.kopo.inMemory.controller;

import kr.ac.kopo.inMemory.model.Manager;
import kr.ac.kopo.inMemory.model.Member;
import kr.ac.kopo.inMemory.model.User;

public class AccountMenuController implements MenuController {

	public AccountMenuController() {
		super();
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		IO.println("안녕하세요. 도서관리시스템입니다.");
		int selection = -1;
		while (selection != 3) {
			selection = IO.getInt("항목을 선택하세요(1.회원가입 2.로그인 3.종료) : ");
			switch (selection) {
			case 1:
				join();
				break;
			case 2:
				login();
				break;
			case 3:
				IO.println("프로그램을 종료합니다.");
				break;
			default:
				IO.println("항목이 존재하지 않습니다.");
				break;
			}
		}
	}

	private void join() {
		// TODO Auto-generated method stub

		char c = IO.getChar("관리자인가요?(y/n) : ");
		if (c == 'y' || c == 'Y') {
			User manager = new Manager();

			manager.setId(this.getId());
			manager.setPassword(IO.getString("패스워드 : "));
			manager.setName(IO.getString("이름 : "));
			// TODO::아래 3항목은 제대로 된 형식인지 확인
			manager.setBirth(IO.getString("생년월일(ex.1990.01.01) : "));
			manager.setEmail(IO.getString("이메일 : "));
			manager.setPhoneNumber(IO.getString("전화번호 : "));

			// TODO::관리자 승인 대기 목록에 추가해야함
			MenuController.USERSERVICE.add(manager);
		} else {
			User member = new Member();
			member.setId(this.getId());
			member.setPassword(IO.getString("패스워드 : "));
			member.setName(IO.getString("이름 : "));
			// TODO::아래 3항목은 제대로 된 형식인지 확인
			member.setBirth(IO.getString("생년월일(ex.1990.01.01) : "));
			member.setEmail(IO.getString("이메일 : "));
			member.setPhoneNumber(IO.getString("전화번호 : "));

			MenuController.USERSERVICE.add(member);
		}

	}

	private String getId() {
		String id = null;
		while (true) {
			id = IO.getString("아이디 : ");

			User user = USERSERVICE.getAccount(id);
			if (user == null) {
				break;
			} else {
				IO.println("해당 아이디는 이미 존재합니다. 다시 입력해주세요.");
			}
		}
		return id;
	}

	private void login() {
		// TODO Auto-generated method stub
		String id = IO.getString("아이디 : ");

		User user = USERSERVICE.getAccount(id);
		if (user == null) {
			IO.println("입력하신 정보가 맞지 않습니다.");
			return;
		} 
		
		String pwd = IO.getString("패스워드 : ");
		if(!user.getPassword().equals(pwd)){
			IO.println("입력정보가 맞지 않습니다.");
			return;
		}

		if(user instanceof Manager) {
			char c = IO.getChar("관리자입니다. 항목을 선택하세요(1.관리자메뉴 2.회원메뉴) : ");
			switch (c) {
			case 1:
//				ManagerMenuController managerMC = new ManagerMenuController((Manager)user);
				break;
			case 2:
				// TODO:: 수정
//				MemberMenuController memeberMC = new MemberMenuController((Member)user);
			default:
				IO.println("항목이 존재하지 않습니다.");
				break;
			}
		}
		
	}

}
