package com.xiejun.server.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������������������
 * @author Administrator
 *
 */
public class Server {

	ServerSocket server;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server server=new Server();
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
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			Socket client=server.accept();
			File file=new File("get.txt");
			br=new BufferedReader(
					new InputStreamReader(client.getInputStream()));
		 bw=new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(file)));
			String msg=null;
			while((msg=br.readLine()).length()>0){
				if(msg==null){
					break;
				}
				bw.append(msg);
				bw.append("\r\n");
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				bw.close();
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	/**
	 * ֹͣ������
	 */
	public void stop(){
		
	}
}
