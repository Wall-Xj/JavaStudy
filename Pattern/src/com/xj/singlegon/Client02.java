package com.xj.singlegon;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 测试反射和反序列化破解单例模式
 * @author WanYin
 *
 */
public class Client02 {
	public static void main(String[] args) throws Exception {
		Demo02 d1=Demo02.getInstance();
		Demo02 d2=Demo02.getInstance();
		
		System.out.println(d1);
		System.out.println(d2);
		
		//通过反射破解
		Class<Demo02> clazz=(Class<Demo02>)Class.forName("com.xj.singlegon.Demo02");
		Constructor<Demo02> cunstructor = clazz.getDeclaredConstructor(null);
		cunstructor.setAccessible(true);
		Demo02 d3=cunstructor.newInstance();
		Demo02 d4=cunstructor.newInstance();
		System.out.println(d3);
		System.out.println(d4);
		
		//通过反序列化破解
		ObjectOutputStream oos= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/a.txt")));
		oos.writeObject(d2);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/a.txt")));
		Demo02 d5=(Demo02)ois.readObject();
		System.out.println(d5);
		
		
	}
}
