package com.xiejun.net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * ��ȡ��Դ��Դ����
 * @author Administrator
 *
 */
public class URLDemo02 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		URL url=new URL("http://www.baidu.com");//��ҳ Ĭ����Դ
		//��ȡ��Դ
//		InputStream is=url.openStream();
//		byte[] flush=new byte[1024];
//		int len=0;
//		while(-1!=(len=is.read(flush))){
//			System.out.println(new String(flush,0,len));
//		}
//		is.close();
		

		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("e:/aaa/1.html"),"utf-8"));
		String msg=null;
		while(null!=(msg=br.readLine())){
//			System.out.println(msg);
			bw.write(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
