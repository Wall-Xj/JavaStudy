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
 * 文件的copy
 *  1 、建立联系   File对象   源头 目的地
	2、选择流    
        	文件输入流  InputStream FileInputStream
         	文件输出流  OutputStream FileOutputStream
	3、操作  :  拷贝
        	byte[] flush =new byte[1024];
        	int len =0;
         	while(-1!=(len=输入流.read(flush))){  
                	输出流.write(flush,0,len)
         	}
                             输出流.flush
	4、释放资源 :关闭 两个流
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
			System.out.println("拷贝文件失败");
		}
	}
	
	public static void copyFile(String srcFile, String destFile)
			throws IOException {
		// 1、建立联系 File对象 源(存在且为文件)+目的地（文件可以不存在）
		File src = new File(srcFile);
		File dest = new File(destFile);
		if (!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		if(dest.isDirectory()){
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
		is.close();
		os.close();
	}
}
