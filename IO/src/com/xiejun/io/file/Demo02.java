package com.xiejun.io.file;

import java.io.File;
import java.io.IOException;
/**
 * ���÷�����
 * 1���ļ���
 * 	getName()	�ļ�����·����
 * 	getPath()	·����
 * 	getAbsoluteFile()	����·������Ӧ��File����
 * 	getAbsolutePath()	����·����
 * 	getParent()	��Ŀ¼�����·���ĸ�Ŀ¼������Ϊnull �磬ɾ�������Ľ��
 * 2���ж���Ϣ
 * 	exists()
 * 	canWrite()
 * 	canRead()
 * 	isFile()
 * 	isDirectory()
 * 	isAbsolute():����ƽ̨���죬ie���̷���ͷ��������/��ͷ
 * 3������ �ֽ���	���ܶ�ȡ�ļ��еĳ���
 * 	length()
 * 4��������ɾ��
 * 	createNewFile()	����� �������ļ�
 * 	delete()	ɾ���ļ�
 * 	static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp) Ĭ����ʱ�ռ�
 * 	static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp,Ŀ¼) 
 * 	deleteOnExit() �˳������ɾ����������ɾ����ʱ�ļ�
 * 	
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//test2();
		try {
			test3();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�����ʧ��");
		}
	}
	//����ɾ���ļ�
	public static void test3() throws IOException{
		String path="E:/aaa/1.txt";
		File src=new File(path);
		if(!src.exists()){
			boolean flag=src.createNewFile();
			System.out.println(flag?"�ɹ�":"ʧ��");
		}
		File temp=File.createTempFile("tes", ".temp",new File("E:/aaa"));
		try {
			Thread.sleep(3000);
			temp.deleteOnExit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//2���ж���Ϣ
	public static void test2(){
		String path="E:"+File.separator+"aaa"+File.separator+"a.txt";
		//String path="E:"+File.separator+"aaa";
		//String path="a.txt";
		File src=new File(path);
		System.out.println("�ļ��Ƿ���ڣ�"+src.exists());
		System.out.println("�ļ��Ƿ��д��"+src.canRead());
		if(src.isFile()){
			System.out.println("�ļ�");
		}else if(src.isDirectory()){
			//û�����Ǵ��ڵ�Ĭ��Ϊ�ļ���
			System.out.println("�ļ���");
		}else{
			System.out.println("�ļ�������");
		}	
		System.out.println(src.isAbsolute());
		System.out.println("����Ϊ��"+src.length());
		
	}
	//1������
	public static void test1(){
		String filePath="E:"+File.separator+"aaa"+File.separator+"a.txt";
		//������ϵ
		File file=new File(filePath);
		file=new File("a.txt");
		System.out.println(file.getName());//��������
		System.out.println(file.getPath());//����Ǿ���·������������·�������򷵻����·��
		System.out.println(file.getAbsolutePath());//���ؾ���·��
		System.out.println(file.getParent());//�����ϼ�Ŀ¼���������ԣ�����null
		
	}
}
