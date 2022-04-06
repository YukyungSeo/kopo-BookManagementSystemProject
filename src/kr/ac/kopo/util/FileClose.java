package kr.ac.kopo.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileClose {

	public static void close(InputStream is) {
		if (is != null)
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static void close(OutputStream os) {
		if (os != null)
			try {
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static void close(InputStream fis, InputStream is) {
		FileClose.close(fis);
		FileClose.close(is);
	}

	public static void close(OutputStream fos, OutputStream os) {
		FileClose.close(fos);
		FileClose.close(os);
	}

	public static void close(Reader r) {
		if (r != null) {
			try {
				r.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Writer w) {
		if (w != null) {
			try {
				w.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Reader fr, Reader r) {
		FileClose.close(fr);
		FileClose.close(r);
	}

	public static void close(Writer fw, Writer w) {
		FileClose.close(fw);
		FileClose.close(w);
	}
}
