package com.xiejun.io.byteIO;

import java.io.File;
import java.io.IOException;

/**
 * 文件夹的拷贝
 * 1、文件 复制  copyFile
 * 2、文件夹  创建   mkdirs()
 * 3、递归查找子孙级
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		//源目录
		String srcPath="e:/aaa";
		//目标目录
		String destPath="e:/aaa/parent";
		try {
			copyDir(srcPath,destPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyDir(String srcPath,String destPath) throws IOException{
		File src=new File(srcPath);
		File dest=new File(destPath);
		if(src.isDirectory()){
			dest=new File(dest,src.getName());
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				System.out.println("父目录不能拷贝到子目录中");
				return;
			}
			
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
	
}
