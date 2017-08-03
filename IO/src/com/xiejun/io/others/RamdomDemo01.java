package com.xiejun.io.others;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.xiejun.io.util.FileUtil;
/**
 * 文件分割思路
 * 1、分割块数 size n块
 * 1、每块的大小 blockSize
 * 	最后：总的文件大小 -（n-1）*blockSize
 * @author Administrator
 *
 */
public class RamdomDemo01 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		RandomAccessFile rnd=new RandomAccessFile(new File("e:/aaa/2.txt"),"r");
		rnd.seek(10);
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=rnd.read(flush))){
			System.out.println(new String(flush,0,len,"utf-8"));
		}
		FileUtil.close(rnd);
	}

}
