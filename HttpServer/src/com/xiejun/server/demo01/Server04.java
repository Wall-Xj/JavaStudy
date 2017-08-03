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
 * 创建服务器，并启动
 * @author Administrator
 *
 */
public class Server04 {

	ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server04 server=new Server04();
		server.start();
	}
	/**
	 * 启动方法
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
	 * 接收客户端
	 */
	private void receive(){
		try {
			Socket client =server.accept();			
			byte[] data=new byte[20480];
			int len =client.getInputStream().read(data);				
			//接收客户端的请求信息
			String requestInfo=new String(data,0,len).trim();	
			System.out.println(requestInfo);
			
			
			//响应
			StringBuilder responseContext =new StringBuilder();
			responseContext.append("<html><head><title>HTTP响应示例</title>" +
					"</head><body>Hello bjsxt!</body></html>");
			Response rsp=new Response(client.getOutputStream());
			rsp.println("<html><head><title>HTTP响应示例</title>");
			rsp.println("</head><body>Hello xiejun!</body></html>");
			rsp.pushToClient(500);
			
			
		} catch (IOException e) {
		}
	}
	/**
	 * 停止服务器
	 */
	public void stop(){
		
	}
}
