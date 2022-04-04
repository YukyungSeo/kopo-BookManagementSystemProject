package kr.ac.kopo.inMemory;

import kr.ac.kopo.inMemory.controller.AccountMenuController;

public class BookManagementSystemMain {

	public static void main(String[] args) {
		AccountMenuController amc = new AccountMenuController();
		amc.process();
	}
}
