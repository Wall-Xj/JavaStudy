package com.xiejun.io.charIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02 {
	public static void main(String[] args) {
		File dest=new File("e:/aaa/1.txt");
		Writer wr=null;
		try {
			wr=new FileWriter(dest,true);
			String str="no fucking excuse\r\njust go";
			wr.write(str);
			wr.append("¶¼ÊÇ");
			wr.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(null!=wr){
				wr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
