package kr.ac.kopo.inFile.da;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import kr.ac.kopo.model.User;
import kr.ac.kopo.util.FileReadWrite;

public class UserDA implements MapDA<String, User> {

	private static Map<String, User> USERMAP;
	private final String dbFilename = "UserData";

	@SuppressWarnings("unchecked")
	public UserDA() {
		super();
		UserDA.USERMAP = (Map<String, User>) FileReadWrite.read(dbFilename);

		// debugging
//		Set<Entry<String, User>> set = UserDA.USERMAP.entrySet();
//		for (Entry<String, User> entry : set) {
//			System.out.println(entry.getValue());
//		}
	}

	public Map<String, User> getUSERMAP() {
		return UserDA.USERMAP;
	}

	@Override
	public boolean add(String k, User v) {
		boolean bool1 = UserDA.USERMAP.put(k, v) == null;
		boolean bool2 = FileReadWrite.write(dbFilename, UserDA.USERMAP);
		return bool1 && bool2;
	}

	@Override
	public User remove(String k) {
		User user = UserDA.USERMAP.remove(k);
		FileReadWrite.write(dbFilename, UserDA.USERMAP);
		return user;
	}

	@Override
	public User get(String k) {
		return UserDA.USERMAP.get(k);
	}

	@Override
	public ArrayList<User> getList(String value) {
		ArrayList<User> arr = new ArrayList<User>();

		Set<Entry<String, User>> set = this.getUSERMAP().entrySet();
		for (Entry<String, User> entry : set) {
			User user = entry.getValue();
			if (user.getId().contains(value) || user.getName().contains(value) || user.getBirth().contains(value)
					|| user.getEmail().contains(value) || user.getPhoneNumber().contains(value)) {
				arr.add(user);
			}
		}
		return arr;
	}

	@Override
	public void saveData() {
		FileReadWrite.write(dbFilename, UserDA.USERMAP);
	}

}
