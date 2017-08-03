package com.xiejun.io.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * д���ļ�
 *  1 ��������ϵ   File����  Ŀ�ĵ�
	2��ѡ����     �ļ������  OutputStream FileOutputStream
	3������  :  write() +flush
	4���ͷ���Դ���ر�
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//1 ��������ϵ   File����  Ŀ�ĵ�
		File src=new File("E:/aaa/1.txt");
		//2��ѡ����     �ļ������ 
		OutputStream os=null;
		try {
			os=new FileOutputStream(src,true);
			//3������
			String str="dsds dsad \r\n";
			byte[] data=str.getBytes();
			os.write(data,0,data.length);
			os.flush();//ǿ��ˢ�³�ȥ
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�δ�ҵ�");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�д��ʧ��");
		}finally{
			if(null!=os){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("�ر������ʧ��");
				}
			}
		}
	}
}
