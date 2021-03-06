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
public class Server03 {

	ServerSocket server;
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server03 server=new Server03();
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
			
			
			StringBuilder response =new StringBuilder();
			//1)  HTTP协议版本、状态代码、描述
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//2)  响应头(Response Head)
			response.append("Server:bjsxt Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK").append(CRLF);
			//正文长度 ：字节长度
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			//3)正文之前
			response.append(CRLF);
			//4)正文
			response.append(responseContext);
			
			System.out.println(responseContext);
			
			
			//输出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
		}
	}
	/**
	 * 停止服务器
	 */
	public void stop(){
		
	}
}
