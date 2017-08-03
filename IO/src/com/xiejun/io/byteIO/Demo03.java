package com.xiejun.io.byteIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ļ���copy
 *  1 ��������ϵ   File����   Դͷ Ŀ�ĵ�
	2��ѡ����    
        	�ļ�������  InputStream FileInputStream
         	�ļ������  OutputStream FileOutputStream
	3������  :  ����
        	byte[] flush =new byte[1024];
        	int len =0;
         	while(-1!=(len=������.read(flush))){  
                	�����.write(flush,0,len)
         	}
                             �����.flush
	4���ͷ���Դ :�ر� ������
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args)  {
		String srcFile="E:/aaa/a.txt";
		String destFile="E:/aaa/1.txt";
		try {
			copyFile(srcFile,destFile);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�����ļ�ʧ��");
		}
	}
	
	public static void copyFile(String srcFile, String destFile)
			throws IOException {
		// 1��������ϵ File���� Դ(������Ϊ�ļ�)+Ŀ�ĵأ��ļ����Բ����ڣ�
		File src = new File(srcFile);
		File dest = new File(destFile);
		if (!src.isFile()) {
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
		}
		if(dest.isDirectory()){
			System.out.println("���ܴ������ļ���ͬ�� ���ļ�");
			throw new IOException("���ܴ������ļ���ͬ�� ���ļ�");
		}
		// 2��ѡ����
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		// 3������ : ���� ѭ��+��ȡ+д��
		byte[] flush = new byte[1024];
		int len = 0;
		while (-1 != (len = is.read(flush))) {
			// д��
			os.write(flush, 0, len);
		}
		os.flush();
		is.close();
		os.close();
	}
}
