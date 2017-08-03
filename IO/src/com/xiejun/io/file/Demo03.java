package com.xiejun.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 5������Ŀ¼
 * 	mkdir()	����Ŀ¼������ȷ����Ŀ¼�Ĵ��ڣ����򴴽�ʧ��
 * 	mkdirs() ����Ŀ¼�������Ŀ¼��������һͬ����
 * 	list() �ļ�|Ŀ¼�ַ�����ʽ
 * 	listFiles()
 * 	static listRoots() ��Ŀ¼
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String path="E:/aaa";
		File src=new File(path);//�ļ���
		if(src.isDirectory()){//���ڲ���ΪĿ¼
			System.out.println("=====��Ŀ¼|�ļ���");
			String[] subNames=src.list();
			for(String name : subNames){
				System.out.println(name);
			}
			System.out.println("=====��Ŀ¼|�ļ�File����===");
			File[] subFiles=src.listFiles();
			for(File temp:subFiles){
				System.out.println(temp.getAbsolutePath());
			}
			System.out.println("=====��Ŀ¼|.txt===");
			//�������ģʽ
			subFiles=src.listFiles(new FilenameFilter(){

				@Override
				public boolean accept(File dir, String name) {
					//System.out.println(dir.getAbsolutePath());
					return new File(dir,name).isFile()&& name.endsWith(".txt");
				}
				
			});
			for(File temp:subFiles){
				System.out.println(temp.getAbsolutePath());
			}
		}
		
	}
	
	public static void test1(){
		String path="E:/aaa/parent/test";
		File src=new File(path);
		//src.mkdir();
		src.mkdirs();
	}
}
