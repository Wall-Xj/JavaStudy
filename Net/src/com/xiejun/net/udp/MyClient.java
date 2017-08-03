package com.xiejun.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * �ͻ���
 * 1�������ͻ���+�˿�
 * 2��׼������
 * 3����������͵ĵص㼰�˿ڣ�
 * 4������
 * 5���ͷ�
 * @author Administrator
 *
 */
public class MyClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1�������ͻ���+�˿�
		DatagramSocket client=new DatagramSocket(6666);
		//2��׼������
		String msg="udp���";
		byte[] data=msg.getBytes();
		//3����������͵ĵص㼰�˿ڣ�
		DatagramPacket packet=new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
		//4������
		client.send(packet);
		//5���ͷ�
		client.close();
	}

}
