package com.xiejun.io.others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo01 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("���ٻش��Ƿ�Ϸ���");
		PrintStream ps=System.out;
		ps.print(true);
		
		//������ļ�
		File src=new File("e:/aaa/print.txt");
		ps=new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
		ps.println("�����ۺ�");
		ps.flush();
		ps.close();
	}

}
