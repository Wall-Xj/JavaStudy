package com.xj.others.three;

import java.lang.ref.WeakReference;

/**
 * ���õķ��ࣺǿ����������
 * ǿ��������
 * @author Administrator
 *
 */
public class RefTest {
	public static void main(String[] args) {
		//�ַ��������� �������ܻ��գ�
		String str=new String("No fucking excuses. Just go��");
		WeakReference<String>wr=new WeakReference<String>(str);
		System.out.println("GC����ǰ��"+wr.get());
		//�Ͽ�����
		str=null;
		System.gc();
		System.runFinalization();
		System.out.println("GC���к�"+wr.get());
	}
	
	public static void test(){
		//�ַ��������� �������ܻ��գ�
		String str="No fucking excuses. Just go��";
		WeakReference<String>wr=new WeakReference<String>(str);
		System.out.println("GC����ǰ��"+wr.get());
		//�Ͽ�����
		str=null;
		System.gc();
		System.runFinalization();
		System.out.println("GC���к�"+wr.get());
	}
}
