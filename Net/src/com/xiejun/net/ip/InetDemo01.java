package com.xiejun.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress����
		InetAddress ads=InetAddress.getLocalHost();
		System.out.println(ads.getHostAddress());
		System.out.println(ads.getHostName());//����������
		//���������õ�InetAddress����
		ads=InetAddress.getByName("www.baidu.com");
		System.out.println(ads.getHostAddress());//���ط�������ip
		System.out.println(ads.getHostName());//��������
		//����ip�õ�InetAddress����
		ads=InetAddress.getByName("115.239.210.27");
		System.out.println(ads.getHostAddress());//���ط�������ip
		System.out.println(ads.getHostName());//���ip��ַ�����ڻ���DNS���ܽ���������ip�����򷵻�����
	}

}
