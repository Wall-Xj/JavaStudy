package com.xiejun.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Ӧ�÷����API����ȡ�����Ϣ��������ơ����ԡ��������������ȣ�
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path="com.xiejun.test.bean.User";
		try {
			Class<?> clz=Class.forName(path);
			
			//��ȡ�������
			System.out.println(clz.getName());
			System.out.println(clz.getSimpleName());
			
			//��ȡ������Ϣ
			//Field[] fields=clz.getFields();//ֻ�ܻ��public ��field
			Field[] fields=clz.getDeclaredFields();//������е�field
			System.out.println(fields.length);
			Field f=clz.getDeclaredField("uname");
			for(Field temp:fields){
				System.out.println("���ԣ�"+temp);
			}
			
			//��ȡ������Ϣ
			Method[] methods=clz.getDeclaredMethods();
			Method m01=clz.getDeclaredMethod("getUname", null);
			//��������в���������봫�ݲ������Ͷ�Ӧ��class����
			Method m02=clz.getDeclaredMethod("setUname", String.class);
			for(Method temp:methods){
				System.out.println("������"+temp);
			}
			
			//��ȡ��������Ϣ
			Constructor[] constructors=clz.getDeclaredConstructors();
			Constructor c01=clz.getDeclaredConstructor(null);
			Constructor c02=clz.getDeclaredConstructor(int.class,String.class,int.class);
			System.out.println(c02);
			for(Constructor temp:constructors){
				System.out.println("��������"+temp);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
