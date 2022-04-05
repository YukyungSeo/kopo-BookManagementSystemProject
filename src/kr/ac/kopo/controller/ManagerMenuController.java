package kr.ac.kopo.controller;

import kr.ac.kopo.model.Manager;

public class ManagerMenuController extends UserMenuController {

	Manager manager;

	public ManagerMenuController() {
		super();
	}

	public ManagerMenuController(Manager manager) {
		super();
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		IO.println("관리자 page 입니다.");
		

	}

}
