package kr.ac.kopo.inMemory.controller;

import kr.ac.kopo.inMemory.service.BookManagementService;
import kr.ac.kopo.inMemory.service.UserManagementService;
import kr.ac.kopo.util.ScannerIOUtil;

public interface MenuController {
	
	public static final ScannerIOUtil IO = new ScannerIOUtil();
	public static final UserManagementService  USERSERVICE = new UserManagementService();
	public static final BookManagementService BOOKSERVICE = new BookManagementService();
	
	public void process();
	
}
