package com.xiejun.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 封装端口：在InetAddress基础上+端口
 * @author Administrator
 *
 */
public class InetSocketDemo01 {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		InetSocketAddress address=new InetSocketAddress("127.0.0.1",8888);
		address=new InetSocketAddress(InetAddress.getLocalHost(),8888);
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		InetAddress ads=address.getAddress();
		System.out.println(ads.getHostAddress());
		System.out.println(ads.getHostName());
	}

}
