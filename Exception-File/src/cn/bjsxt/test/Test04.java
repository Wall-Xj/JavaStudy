package cn.bjsxt.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) {
		try {
			String str = new Test04().openFile();
			System.out.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String openFile() throws FileNotFoundException, IOException {
		FileReader reader = new FileReader("d:/a.txt");
		char c = (char) reader.read();
		reader.close();
		return "" + c;
	}
	
	void test(){
		File file=new File("d:/a.txt");
		if(file.exists()){
			try {
				throw new FileNotFoundException("File can't be found!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
