package kr.ac.kopo.inMemory.controller;

import kr.ac.kopo.inMemory.model.Manager;

public class ManagerMenuController implements MenuController {

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

	}

}
