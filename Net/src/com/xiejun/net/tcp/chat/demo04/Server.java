package com.xiejun.net.tcp.chat.demo04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

/**
 * ����������
 * д�����ݣ������
 * ��ȡ���ݣ�������
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
			all.add(channel);//ͳһ����
			new Thread(channel).start();
		}
	}

	/**
	 * һ���ͻ���һ����·
	 * 1��������
	 * 2�������
	 * 3����������
	 * 4����������
	 * @author Administrator
	 *
	 */
	private class MyChannel implements Runnable{
		//������
		private DataInputStream dis;
		//�����
		private DataOutputStream dos;
		private boolean isRunning=true;
		private String name;
		public MyChannel(Socket client){
			try {
				dis=new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
				this.name=dis.readUTF();
				send("��ӭ����������");
				sendOthers(this.name+"������������");
			} catch (IOException e) {
				//e.printStackTrace();
				isRunning=false;
				CloseUtil.closeAll(dos,dis);
				all.remove(this);
			}
		}
		/**
		 * ��ȡ����
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
		
		private void sendOthers(String msg){
			//�Ƿ�Ϊ˽��Լ��
			if(msg.startsWith("@")&&msg.indexOf(":")>-1){
				//��ȡmane
				String name=msg.substring(1,msg.indexOf(":"));
				String content=msg.substring(msg.indexOf(":")+1);
				//��������
				for(MyChannel other:all){
					if(other.name.equals(name)){
						//���������ͻ���
						other.send(this.name+"����˵��"+content);
					}
				}
			}else{				
				//��������
				for(MyChannel other:all){
					if(other==this){
						continue;
					}
					//���������ͻ���
					other.send(this.name+"�Դ��˵��"+msg);
				}
			}
		}
		
		@Override
		public void run() {
			while(isRunning){
				sendOthers(receive());
			}
		}
	}
}
