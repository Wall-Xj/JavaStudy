package com.xiejun.net.tcp.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1、创建服务器 	指定端口
 * 2、接受客户端的链接		 阻塞式
 * 3、接收数据+发送数据
 * @author Administrator
 *
 */
public class MultiServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1、创建服务器 	指定端口
		ServerSocket server=new ServerSocket(8888);
		//2、接受客户端的链接		 阻塞式
		while(true){
			Socket socket=server.accept();
			System.out.println("一个客户端建立连接");
			//发送数据
			String msg="但很舒服";
			//输出流
	
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		}
	}

}
