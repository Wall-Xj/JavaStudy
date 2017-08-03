package com.xiejun.server.demo01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������������������
 * @author Administrator
 *
 */
public class Server02 {

	ServerSocket server;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server02 server=new Server02();
		server.start();
	}
	/**
	 * ��������
	 */
	public void start(){
		try {
			server = new ServerSocket(7777);			
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���տͻ���
	 */
	private void receive(){
		try {
			Socket client=server.accept();
			File file=new File("post.txt");
			//���տͻ��˵�������Ϣ
			BufferedInputStream bis=new BufferedInputStream(
					client.getInputStream());
			BufferedOutputStream bos=new BufferedOutputStream(
					new FileOutputStream(file));
			byte[] flush=new byte[1024];
			int len=0;
			while(-1!=(len=bis.read(flush))){
				bos.write(flush,0,len);
			}
			bos.flush();
			bos.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stop(){
		
	}
}
