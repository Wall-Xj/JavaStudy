package com.xiejun.net.tcp.chat.demo03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据
 * @author Administrator
 *
 */
public class Send implements Runnable {
	//控制台的输入流
	private BufferedReader console;
	//管道的输出流
	private DataOutputStream dos;
	//控制线程标识
	private boolean isRunning=true;
	public Send() {
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Send(Socket client){
		this();
		try {
			dos=new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			//e.printStackTrace();
			isRunning=false;
			CloseUtil.closeAll(dos,console);
		}
	}
	
	//1、从控制台接收数据
	private String getMsgFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			// e.printStackTrace();
		}
		return "";
	}
	/**
	 * 1、从控制台接收数据
	 * 2、发送数据
	 */
	public void send(){
		String msg=getMsgFromConsole();
		if(msg!=null&&!msg.equals("")){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning=false;
				CloseUtil.closeAll(dos,console);
			}
		}
	}
	
	@Override
	public void run() {
		while(isRunning){
			send();
		}
		
	}

}
