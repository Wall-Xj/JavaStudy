package com.xiejun.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayDemo02 {
	public static void main(String[] args) {
		try {
			byte[] data=getBytesFromFile("e:/aaa/1.txt");
			toFileFromByteArray(data,"e:/aaa/2.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void toFileFromByteArray(byte[] src,String destPath) throws IOException{
		//Ŀ�ĵ�
		File dest=new File(destPath);
		//ѡ����
		//�ֽ�����������
		InputStream is=new BufferedInputStream(new ByteArrayInputStream(src));
		//�ļ������
		OutputStream os=new BufferedOutputStream(new FileOutputStream(dest));
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			os.write(flush,0,len);
		}
		os.flush();
		os.close();
		is.close();
	}
	

	/**
	 * �ļ�--������--���ֽ�����
	 * @param srcPath
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesFromFile(String srcPath) throws IOException {
		//�����ļ�Դ
		File src = new File(srcPath);
		//�ֽ�����Ŀ�ĵ�
		byte[] dest = null;
		//�ļ�������
		InputStream is = new BufferedInputStream(
						new FileInputStream(src)
						);
		//�ֽ���������� ����ʹ�ö�̬
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//����  ���϶�ȡ�ļ�   д�����ֽ���������
		byte[] flush = new byte[1024];
		int len = 0;
		while (-1 != (len = is.read(flush))) {
			//д�����ֽ���������
			bos.write(flush, 0, len);
		}
		bos.flush();
		//��ȡ����
		dest=bos.toByteArray();
		bos.close();
		is.close();
		return dest;
	}
}
