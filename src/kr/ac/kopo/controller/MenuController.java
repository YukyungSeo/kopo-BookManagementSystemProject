package kr.ac.kopo.controller;

import kr.ac.kopo.util.PrintBoundaryUtil;

public interface MenuController extends Controller {

	public static final PrintBoundaryUtil PBU = new PrintBoundaryUtil(IO);

	public abstract void process();

}
