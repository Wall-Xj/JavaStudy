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
	 * �����ļ�
	 * @param srcFile	Դ�ļ�·��
	 * @param destFile	Ŀ���ļ�·��
	 * @throws IOException
	 */
	public static void copyFile(String srcFile, String destFile)
			throws IOException {
		copyFile(new File(srcFile),new File(destFile));
	}
	
	/**
	 * �����ļ�
	 * @param srcFile	Դ�ļ�File����
	 * @param destFile	Ŀ���ļ�File����
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile)
			throws IOException {
		if (!srcFile.isFile()) {
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
		}
		//���destΪ�Ѿ����ڵ��ļ��У����ܽ������ļ���ͬ�����ļ�
		if(destFile.isDirectory()){
			System.out.println("���ܽ������ļ���ͬ�����ļ�");
			throw new IOException("���ܽ������ļ���ͬ�����ļ�");
		}
		// 2��ѡ����
		InputStream is = new FileInputStream(srcFile);
		OutputStream os = new FileOutputStream(destFile);
		// 3������ : ���� ѭ��+��ȡ+д��
		byte[] flush = new byte[1024];
		int len = 0;
		while (-1 != (len = is.read(flush))) {
			// д��
			os.write(flush, 0, len);
		}
		os.flush();
		is.close();
		os.close();
	}
}
