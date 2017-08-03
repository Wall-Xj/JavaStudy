package com.xiejun.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.xiejun.test.bean.User;

/**
 * ͨ�����䣻API��̬�Ĳ�����������������������
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String path="com.xiejun.test.bean.User";
		try {
			Class<User> clz=(Class<User>)Class.forName(path);
			
			//ͨ������api���ù��췽�����������
			User u=clz.newInstance();//������User���޲ι��췽��
			System.out.println(u);
			
			Constructor<User> c=clz.getDeclaredConstructor(int.class,String.class,int.class);
			User u2=c.newInstance(100,"marry",25);
			System.out.println(u2.getUname());
			
			//ͨ������API������ͨ����
			User u3=clz.newInstance();
			Method method=clz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3, "tom");
			System.out.println(u3.getUname());
			
			//ͨ������API����
			User u4=clz.newInstance();
			Field f=clz.getDeclaredField("uname");
			f.setAccessible(true);//������Բ���Ҫ����ȫ��飬����ֱ�ӷ���
			f.set(u4,"jack");//ͨ������д���Ե�ֵ
			System.out.println(u4.getUname());//ͨ����������Ե�ֵ
			System.out.println(f.get(u4));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
