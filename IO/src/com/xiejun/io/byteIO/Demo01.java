package com.xiejun.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ļ��Ķ�ȡ
 *  1 ��������ϵ   File���� Դͷ
	2��ѡ����     �ļ�������  InputStream FileInputStream
	3������  : byte[] car =new byte[1024];  +read+��ȡ��С
             ���
	4���ͷ���Դ :�ر�
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//1��������ϵ  File����
		File src=new File("E:/aaa/a.txt");
		//2��ѡ����
		InputStream is=null;
		try {
			is=new FileInputStream(src);
			//3���������϶�ȡ ��������
			byte[] car=new byte[10];
			int len=0;//���� ʵ�ʶ�ȡ�Ĵ�С
			//4��ѭ����ȡs
			while(-1!=(len=is.read(car))){
				//��� �ֽ�����ת���ַ���
				String info=new String(car,0,len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("��ȡ�ļ�ʧ��");
		}finally{
			//4���ͷ���Դ
			if(null!=is){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("�ر��ļ�������ʧ��");
				}
			}
			
			
		}
	}
}
