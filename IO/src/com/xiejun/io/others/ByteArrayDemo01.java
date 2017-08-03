package com.xiejun.io.others;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayDemo01 {
	public static void main(String[] args) throws IOException {
		read(write());
	}
	
	public static void read(byte[] data) throws IOException{
		InputStream is=new BufferedInputStream(
				new ByteArrayInputStream(data)
				);
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			System.out.println(new String(flush,0,len));
		}
		is.close();
	}
	
	public static byte[] write() throws IOException{
		byte[] dest;
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		String str="广东移动飒沓示范村";
		byte[] data=str.getBytes();
		bos.write(data,0,data.length);
		dest=bos.toByteArray();
		bos.close();
		return dest;
	}
}
