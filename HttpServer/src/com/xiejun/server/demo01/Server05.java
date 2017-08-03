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
public class Server05 {

	ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server05 server=new Server05();
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
			//����
			Request req=new Request(client.getInputStream());			
			
			
			//��Ӧ
			StringBuilder responseContext =new StringBuilder();
			responseContext.append("<html><head><title>HTTP��Ӧʾ��</title>" +
					"</head><body>Hello bjsxt!</body></html>");
			Response rsp=new Response(client.getOutputStream());
			rsp.println("<html><head><title>HTTP��Ӧʾ��</title>");
			rsp.println("</head><body>");
			rsp.println("��ӭ��").println(req.getParameter("name")).println("����");
			rsp.println("</body></html>");
			
			rsp.pushToClient(500);
			
			
		} catch (IOException e) {
		}
	}
	/**
	 * ֹͣ������
	 */
	public void stop(){
		
	}
}
