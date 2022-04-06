package kr.ac.kopo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class FileReadWrite {

	public static void write(String filename, Map<?, ?> map) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("DBfiles/" + filename);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(map);
			System.out.println("log : "+ filename +" 데이터 저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(oos, fos);
		}
	}

	public static Object read(String filename) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			
			File fileObj = new File("DBfiles/" + filename);
			if(!fileObj.exists())
				fileObj.createNewFile();
			fis = new FileInputStream(fileObj);
			ois = new ObjectInputStream(fis);

			Object obj = ois.readObject();

			if (obj instanceof Map) {
				return obj;
			}

		} catch (Exception e) {
//			System.out.println(e.getMessage());
		} finally {
			FileClose.close(ois, fis);
		}

		return new HashMap<>();
	}
}
