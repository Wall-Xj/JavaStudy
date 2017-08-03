package com.xiejun.io.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BuffereByteDemo {
	public static void main(String[] args) throws IOException {
		String srcFile = "E:/aaa/a.txt";
		String destFile = "E:/aaa/1.txt";
		// 1��������ϵ File���� Դ(������Ϊ�ļ�)+Ŀ�ĵأ��ļ����Բ����ڣ�
		File src = new File(srcFile);
		File dest = new File(destFile);
		if (!src.isFile()) {
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
		}
		if (dest.isDirectory()) {
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
		os.close();
		is.close();
		
	}
}
