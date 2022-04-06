package kr.ac.kopo.da;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import kr.ac.kopo.model.Borrow;

public class BorrowDA implements MapDA<String, Borrow> {

	private final static Map<String, Borrow> BORROWMAP = new HashMap<>();

	public BorrowDA() {
		super();
	}

	public Map<String, Borrow> getBORROWMAP() {
		return BORROWMAP;
	}

	public boolean containISBN(String k) {
		return this.get(k) != null;
	}

	@Override
	public boolean add(String k, Borrow v) {
		return BORROWMAP.put(k, v) == null;
	}

	@Override
	public Borrow remove(String k) {
		// TODO Auto-generated method stub
		return BORROWMAP.remove(k);
	}

	@Override
	public Borrow get(String k) {
		return BORROWMAP.get(k);
	}

	@Override
	public ArrayList<Borrow> getList(String value) {
		ArrayList<Borrow> arr = new ArrayList<Borrow>();

		Set<Entry<String, Borrow>> set = this.getBORROWMAP().entrySet();
		for (Entry<String, Borrow> entry : set) {
			Borrow borrow = entry.getValue();
			if (borrow.getIsbn().contains(value) || borrow.getTitle().contains(value)
					|| borrow.getUserId().contains(value)) {
				arr.add(borrow);
			}
		}
		return arr;
	}

	public ArrayList<Borrow> getListWithID(String userid) {
		ArrayList<Borrow> arr = new ArrayList<Borrow>();

		Set<Entry<String, Borrow>> set = this.getBORROWMAP().entrySet();
		for (Entry<String, Borrow> entry : set) {
			Borrow borrow = entry.getValue();
			if (borrow.getUserId().contains(userid)) {
				arr.add(borrow);
			}
		}
		return arr;
	}

}
