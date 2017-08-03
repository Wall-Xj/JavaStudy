package com.xiejun.io.util;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
	/**
	 * ������ر���
	 * �ɱ������... ֻ���β����һ��λ�ã�����ʽ������һ��
	 * @param io
	 */
	public static void close(Closeable ... io){
		for(Closeable temp:io){
			if(null!=temp){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static <T extends Closeable> void claseAll(T ... io){
		for(Closeable temp:io){
			if(null!=temp){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
