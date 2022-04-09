package kr.ac.kopo.controller;

public class ModifyPrivateInfoMenuController implements MenuController {

	private UserMenuController umc;

	public ModifyPrivateInfoMenuController(UserMenuController umc) {
		this.setUmc(umc);
	}

	public UserMenuController getUmc() {
		return umc;
	}

	public void setUmc(UserMenuController umc) {
		this.umc = umc;
	}

	@Override
	public void process() {

		PBU.boundaryOfMenuStart();
		IO.println(" < 회원 page - 개인정보수정 page 입니다. >");

		if (!this.checkAuthority())
			return;

		int selection = IO.getInt("수정하고 싶은 항목을 선택하세요(1.비밀번호 2.이메일 3.전화번호 4.회원탈퇴 5.이전메뉴) : ");
		switch (selection) {
		case 1:
			this.modifyPwd();
			break;
		case 2:
			this.modifyEmail();
			break;
		case 3:
			this.modifyPhoneNumber();
			break;
		case 4:
			this.resign();
			return;
		case 5:
			break;
		default:
			IO.println("항목이 존재하지 않습니다. 이전 메뉴로 돌아갑니다.");
			break;
		}
		PBU.boundaryOfMenuEnd();
	}

	private boolean checkAuthority() {
		String pwd = IO.getString("현재 비밀번호를 입력해주세요 : ");
		if (!this.umc.getUser().getPassword().equals(pwd)) {
			IO.println("비밀번호가 일치하지 않습니다. 개인정보를 수정할 수 없습니다.");
			return false;
		}
		return true;
	}

	private void modifyPwd() {
		String newPwd = IO.getString("새로운 패스워드 : ");
		if (newPwd.equals(IO.getString("새로운 패스워드 재입력 : "))) {
			this.umc.getUser().setPassword(newPwd);
			IO.println("비밀번호가 수정되었습니다.");
		} else {
			IO.println("비밀번호가 일치하지 않습니다. 비밀번호 수정에 실패하였습니다.");
		}
	}

	private void modifyEmail() {
		this.umc.getUser().setEmail(IO.getString("이메일 : "));
		IO.println("이메일이 수정되었습니다.");
	}

	private void modifyPhoneNumber() {
		this.umc.getUser().setPhoneNumber(IO.getString("전화번호 : "));
		IO.println("전화번호가 수정되었습니다.");
	}

	private void resign() {
		if (!this.checkAuthority())
			return;
		
		AccountController ac = new AccountController();
		if (ac.resign(this.umc.getUser()))
			this.umc.setUser(null);
	}

}
