package com.xiejun.net.tcp.chat.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * 写出数据：输出流
 * 读取数据：输入流
 * @author Administrator
 *
 */
public class Server {
	private List<MyChannel>all=new ArrayList<MyChannel>();
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new Server().start();
	}
	
	public void start() throws IOException{
		ServerSocket server=new ServerSocket(8888);
		while(true){
			Socket client=server.accept();
			MyChannel channel=new MyChannel(client);
			all.add(channel);//统一管理
			new Thread(channel).start();
		}
	}

	/**
	 * 一个客户端一条道路
	 * 1、输入流
	 * 2、输出流
	 * 3、接收数据
	 * 4、发送数据
	 * @author Administrator
	 *
	 */
	private class MyChannel implements Runnable{
		//输入流
		private DataInputStream dis;
		//输出流
		private DataOutputStream dos;
		private boolean isRunning=true;
		public MyChannel(Socket client){
			try {
				dis=new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				//e.printStackTrace();
				isRunning=false;
				CloseUtil.closeAll(dos,dis);
				all.remove(this);
			}
		}
		/**
		 * 读取数据
		 * @return
		 */
		private String receive(){
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				// e.printStackTrace();
				isRunning=false;
				CloseUtil.closeAll(dis);
				all.remove(this);
			}
			return msg;
		}
		
		private void send(String msg){
			if(null==msg||msg.equals("")){
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				isRunning=false;
				CloseUtil.closeAll(dos);
				all.remove(this);
			}
		}
		
		private void sendOthers(){
			String msg=receive();
			//遍历容器
			for(MyChannel other:all){
				if(other==this){
					continue;
				}
				//发送其他客户端
				other.send(msg);
			}
			
		}
		
		@Override
		public void run() {
			while(isRunning){
				sendOthers();
			}
		}
	}
}
