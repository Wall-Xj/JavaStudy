package cn.bjsxt.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) {
		FileInputStream fls =null;
		try {
			fls = new FileInputStream("d:/a.txt");
			int c;
			while((c=fls.read())!=-1){
				System.out.print((char)c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fls!=null){
				try {
					fls.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
