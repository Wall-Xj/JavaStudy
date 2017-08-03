package com.xiejun.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	
	public static void copyDir(String srcPath,String destPath) throws IOException{
		File src=new File(srcPath);
		File dest=new File(destPath);
		if(src.isDirectory()){
			dest=new File(dest,src.getName());
		}
		copyDirDetail(src,dest);
	}
	
	public static void copyDirDetail(File src,File dest) throws IOException{
		if(src.isFile()){
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}else if(src.isDirectory()){
			dest.mkdirs();
			for(File sub:src.listFiles()){
				copyDirDetail(sub,new File(dest,sub.getName()));
			}
		}
	}
	
	/**
	 * 拷贝文件
	 * @param srcFile	源文件路径
	 * @param destFile	目标文件路径
	 * @throws IOException
	 */
	public static void copyFile(String srcFile, String destFile)
			throws IOException {
		copyFile(new File(srcFile),new File(destFile));
	}
	
	/**
	 * 拷贝文件
	 * @param srcFile	源文件File对象
	 * @param destFile	目标文件File对象
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile)
			throws IOException {
		if (!srcFile.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		//如果dest为已经存在的文件夹，不能建立与文件夹同名的文件
		if(destFile.isDirectory()){
			System.out.println("不能建立与文件夹同名的文件");
			throw new IOException("不能建立与文件夹同名的文件");
		}
		// 2、选择流
		InputStream is = new FileInputStream(srcFile);
		OutputStream os = new FileOutputStream(destFile);
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
