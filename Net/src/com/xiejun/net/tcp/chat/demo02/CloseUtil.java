package com.xiejun.net.tcp.chat.demo02;

import java.io.Closeable;
import java.io.IOException;

/**
 * �ر����ķ���
 * @author Administrator
 *
 */
public class CloseUtil {

	public static void closeAll(Closeable... io){
		for(Closeable temp:io){
			try {
				if(temp!=null){
				temp.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}

}
