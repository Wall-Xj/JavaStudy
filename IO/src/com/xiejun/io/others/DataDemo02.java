package com.xiejun.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DataDemo02 {
	public static void main(String[] args) throws IOException {
		byte[] data=write();
		read(data);
		System.out.println(data.length);
	}
	
	public static void read(byte[] src) throws IOException{
		DataInputStream dis=new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)
						)
				);
		long num=dis.readLong();
		double point=dis.readDouble();
		String str=dis.readUTF();
		dis.close();
		System.out.println(num);
		System.out.println(point);
		System.out.println(str);
	}
	
	public static byte[] write() throws IOException{
		byte[] dest=new byte[1024];
		String str="浙江离奇土豪开错车";
		long num=1000L;
		double point=12.3;
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(
					new BufferedOutputStream(
							bos
							)
				);
		dos.writeLong(num);
		dos.writeDouble(point);
		dos.writeUTF(str);
		dos.flush();
		dest=bos.toByteArray();
		dos.close();
		
		return dest;
	}
}
