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
import java.util.Date;

/**
 * ������������������
 * @author Administrator
 *
 */
public class Server06 {

	ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server06 server=new Server06();
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
			Socket client =server.accept();			
			Servlet serv=new Servlet();
			Request req =new Request(client.getInputStream());
			Response rep =new Response(client.getOutputStream());
			serv.service(req,rep); 				
			rep.pushToClient(200);	
			
			
		} catch (IOException e) {
		}
	}
	/**
	 * ֹͣ������
	 */
	public void stop(){
		
	}
}
