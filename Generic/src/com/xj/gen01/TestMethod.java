package com.xj.gen01;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * �Ƿ������ж��巺�ͷ���
 * ���壺�ڷ�������ǰ��<��ĸ>
 * @author Administrator
 *
 */
public class TestMethod {
	public static <T> void test(T t){
		System.out.println(t);
	}
	
	
	public static <T extends List<String>> void test(T t){
		t.add("aaa");
		System.out.println(t.get(0));
	}
	
	//�ͷ���Դ...��ʾ�ɱ������[]��Ч
	public static <T extends Closeable> void test(T...ts){
		for(T temp:ts){
			if(temp!=null){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		test("hahah");
		test(new ArrayList<String>());
//		try {
//			test(new FileInputStream("a.txt"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}
