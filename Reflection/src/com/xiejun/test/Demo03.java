package com.xiejun.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.xiejun.test.bean.User;

/**
 * 通过反射；API动态的操作：构造器、方法、属性
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String path="com.xiejun.test.bean.User";
		try {
			Class<User> clz=(Class<User>)Class.forName(path);
			
			//通过反射api调用构造方法，构造对象
			User u=clz.newInstance();//调用了User的无参构造方法
			System.out.println(u);
			
			Constructor<User> c=clz.getDeclaredConstructor(int.class,String.class,int.class);
			User u2=c.newInstance(100,"marry",25);
			System.out.println(u2.getUname());
			
			//通过反射API调用普通方法
			User u3=clz.newInstance();
			Method method=clz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3, "tom");
			System.out.println(u3.getUname());
			
			//通过反射API操作
			User u4=clz.newInstance();
			Field f=clz.getDeclaredField("uname");
			f.setAccessible(true);//这个属性不需要做安全检查，可以直接访问
			f.set(u4,"jack");//通过反射写属性的值
			System.out.println(u4.getUname());//通过反射读属性的值
			System.out.println(f.get(u4));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
