package com.xiejun.net.tcp.chat.demo02;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的方法
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
