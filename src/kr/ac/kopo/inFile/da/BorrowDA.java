package kr.ac.kopo.inFile.da;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import kr.ac.kopo.model.Borrow;
import kr.ac.kopo.util.FileReadWrite;

public class BorrowDA implements MapDA<String, Borrow> {

	private static Map<String, Borrow> BORROWMAP;

	@SuppressWarnings("unchecked")
	public BorrowDA() {
		super();
		BorrowDA.BORROWMAP = (Map<String, Borrow>) FileReadWrite.read("borrow");
	}

	public Map<String, Borrow> getBORROWMAP() {
		return BorrowDA.BORROWMAP;
	}

	public boolean containISBN(String k) {
		return this.get(k) != null;
	}

	@Override
	public boolean add(String k, Borrow v) {
		boolean bool = BorrowDA.BORROWMAP.put(k, v) == null;
		FileReadWrite.write("borrow", BorrowDA.BORROWMAP);
		return bool;
	}

	@Override
	public Borrow remove(String k) {
		Borrow borrow = BorrowDA.BORROWMAP.remove(k);
		FileReadWrite.write("borrow", BorrowDA.BORROWMAP);
		return borrow;
	}

	@Override
	public Borrow get(String k) {
		return BorrowDA.BORROWMAP.get(k);
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
