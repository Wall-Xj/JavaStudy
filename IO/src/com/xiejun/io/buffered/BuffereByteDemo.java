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
		// 1、建立联系 File对象 源(存在且为文件)+目的地（文件可以不存在）
		File src = new File(srcFile);
		File dest = new File(destFile);
		if (!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		if (dest.isDirectory()) {
			System.out.println("不能创建与文件夹同名 的文件");
			throw new IOException("不能创建与文件夹同名 的文件");
		}
		// 2、选择流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		// 3、操作 : 拷贝 循环+读取+写出
		byte[] flush = new byte[1024];
		int len = 0;
		while (-1 != (len = is.read(flush))) {
			// 写出
			os.write(flush, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		
	}
}
