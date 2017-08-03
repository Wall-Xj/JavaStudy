package cn.bjsxt.test;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		File f = new File("E:/99fanTXTFile/sadsa.java");
		// System.out.println(f.canRead());
		// System.out.println(f.canWrite());
		// System.out.println(f.exists());
		// System.out.println(f.isDirectory());
		// System.out.println(f.isFile());
		// System.out.println(f.isHidden());
		// System.out.println(f.isAbsolute());
		// System.out.println(f.lastModified());
		// System.out.println(f.length());
		// System.out.println(f.getName());
		// System.out.println(f.getPath());
		// System.out.println(f.getAbsolutePath());
		// try {
		// System.out.println(f.getCanonicalPath());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// System.out.println(f.getFreeSpace());
		// System.out.println(f.getParent());
		// System.out.println(f.getUsableSpace());
		// System.out.println(f.getAbsoluteFile());
		// System.out.println(f.getClass());
		// System.out.println(f.getParentFile());

		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.delete();

		File f1 = new File("E:/aaa");
		printFile(f1);

	}

	static void printFile(File f) {
		System.out.println(f.getName());
		if (f.isDirectory()) {
			File[] fs = f.listFiles();
			for (File a : fs) {
				printFile(a);
			}
		}
	}
}
