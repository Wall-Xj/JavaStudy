package com.xiejun.io.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class BufferedCharDemo {
	public static void main(String[] args) {
		File src=new File("e:/aaa/1.txt");
		File dest=new File("e:/aaa/a.txt");
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			reader=new BufferedReader(new FileReader(src));
			writer=new BufferedWriter(new FileWriter(dest));
//			char[] flush=new char[1024];
//			int len=0;
//			while(-1!=(len=reader.read(flush))){
//				writer.write(flush,0,len);
//			}
			String line=null;
			while(null!=(line=reader.readLine())){
				writer.write(line);
				writer.newLine();
			}
			
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=writer){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!=reader){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
