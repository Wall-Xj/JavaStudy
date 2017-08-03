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
			//请求
			Request req=new Request(client.getInputStream());			
			
			
			//响应
			StringBuilder responseContext =new StringBuilder();
			responseContext.append("<html><head><title>HTTP响应示例</title>" +
					"</head><body>Hello bjsxt!</body></html>");
			Response rsp=new Response(client.getOutputStream());
			rsp.println("<html><head><title>HTTP响应示例</title>");
			rsp.println("</head><body>");
			rsp.println("欢迎：").println(req.getParameter("name")).println("回来");
			rsp.println("</body></html>");
			
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
