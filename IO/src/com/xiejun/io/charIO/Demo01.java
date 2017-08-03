package com.xiejun.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * ´¿ÎÄ±¾¶ÁÈ¡
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		File src=new File("e:/aaa/1.txt");
		Reader reader=null;
		try {
			reader=new FileReader(src);
			char[] flush=new char[1024];
			int len=0;
			while(-1!=(len=reader.read(flush))){
				String str=new String(flush,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
