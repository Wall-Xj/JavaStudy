package com.xiejun.net.tcp.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1������������ 	ָ���˿�
 * 2�����ܿͻ��˵�����		 ����ʽ
 * 3����������+��������
 * @author Administrator
 *
 */
public class Server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1������������ 	ָ���˿�
		ServerSocket server=new ServerSocket(8888);
		//2�����ܿͻ��˵�����		 ����ʽ
		Socket socket=server.accept();
		System.out.println("һ���ͻ��˽�������");
		//��������
		String msg="�������";
		//�����
		/*BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();
		bw.flush();
		*/
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
	}

}
