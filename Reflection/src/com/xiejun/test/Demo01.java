package com.xiejun.test;

/**
 * ����java.lang.Class����Ļ�ȡ��ʽ
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String path="com.xiejun.test.bean.User";
		try {
			Class<?> clz=Class.forName(path);
			System.out.println(clz);
			
			Class<?>strClz=String.class;
			Class<?>strClz2=path.getClass();
			System.out.println(strClz==strClz2);
			
			Class<?>intClz=int.class;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
