package com.xiejun.io.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 写出文件
 *  1 、建立联系   File对象  目的地
	2、选择流     文件输出流  OutputStream FileOutputStream
	3、操作  :  write() +flush
	4、释放资源：关闭
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//1 、建立联系   File对象  目的地
		File src=new File("E:/aaa/1.txt");
		//2、选择流     文件输出流 
		OutputStream os=null;
		try {
			os=new FileOutputStream(src,true);
			//3、操作
			String str="dsds dsad \r\n";
			byte[] data=str.getBytes();
			os.write(data,0,data.length);
			os.flush();//强制刷新出去
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件写出失败");
		}finally{
			if(null!=os){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭输出流失败");
				}
			}
		}
	}
}
