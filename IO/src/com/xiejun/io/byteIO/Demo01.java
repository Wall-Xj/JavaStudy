package com.xiejun.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件的读取
 *  1 、建立联系   File对象 源头
	2、选择流     文件输入流  InputStream FileInputStream
	3、操作  : byte[] car =new byte[1024];  +read+读取大小
             输出
	4、释放资源 :关闭
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//1、建立联系  File对象
		File src=new File("E:/aaa/a.txt");
		//2、选择流
		InputStream is=null;
		try {
			is=new FileInputStream(src);
			//3、操作不断读取 缓冲数组
			byte[] car=new byte[10];
			int len=0;//接收 实际读取的大小
			//4、循环读取s
			while(-1!=(len=is.read(car))){
				//输出 字节数组转成字符串
				String info=new String(car,0,len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取文件失败");
		}finally{
			//4、释放资源
			if(null!=is){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭文件输入流失败");
				}
			}
			
			
		}
	}
}
