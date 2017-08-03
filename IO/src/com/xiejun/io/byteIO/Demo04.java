package com.xiejun.io.byteIO;

import java.io.File;
import java.io.IOException;

/**
 * �ļ��еĿ���
 * 1���ļ� ����  copyFile
 * 2���ļ���  ����   mkdirs()
 * 3���ݹ�������Ｖ
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		//ԴĿ¼
		String srcPath="e:/aaa";
		//Ŀ��Ŀ¼
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
				System.out.println("��Ŀ¼���ܿ�������Ŀ¼��");
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
