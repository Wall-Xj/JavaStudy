package com.xiejun.io.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Demo02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("e:/aaa/1.txt"), "utf-8"));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("e:/aaa/a.txt"),"utf-8")
				);
		String info=null;
		while(null!=(info=br.readLine())){
			bw.write(info);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
