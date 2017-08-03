package com.xiejun.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象
		InetAddress ads=InetAddress.getLocalHost();
		System.out.println(ads.getHostAddress());
		System.out.println(ads.getHostName());//输出计算机名
		//根据域名得到InetAddress对象
		ads=InetAddress.getByName("www.baidu.com");
		System.out.println(ads.getHostAddress());//返回服务器的ip
		System.out.println(ads.getHostName());//返回域名
		//根据ip得到InetAddress对象
		ads=InetAddress.getByName("115.239.210.27");
		System.out.println(ads.getHostAddress());//返回服务器的ip
		System.out.println(ads.getHostName());//如果ip地址不存在或者DNS不能解析，返回ip，否则返回域名
	}

}
