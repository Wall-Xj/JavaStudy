package com.xiejun.io.util;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
	/**
	 * 工具类关闭流
	 * 可变参数：... 只能形参最后一个位置，处理方式与数组一致
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
