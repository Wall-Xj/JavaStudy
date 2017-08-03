package com.xiejun.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息（类的名称、属性、方法、构造器等）
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path="com.xiejun.test.bean.User";
		try {
			Class<?> clz=Class.forName(path);
			
			//获取类的名称
			System.out.println(clz.getName());
			System.out.println(clz.getSimpleName());
			
			//获取属性信息
			//Field[] fields=clz.getFields();//只能获得public 的field
			Field[] fields=clz.getDeclaredFields();//获得所有的field
			System.out.println(fields.length);
			Field f=clz.getDeclaredField("uname");
			for(Field temp:fields){
				System.out.println("属性："+temp);
			}
			
			//获取方法信息
			Method[] methods=clz.getDeclaredMethods();
			Method m01=clz.getDeclaredMethod("getUname", null);
			//如果方法有参数，则必须传递参数类型对应的class对象
			Method m02=clz.getDeclaredMethod("setUname", String.class);
			for(Method temp:methods){
				System.out.println("方法："+temp);
			}
			
			//获取构造器信息
			Constructor[] constructors=clz.getDeclaredConstructors();
			Constructor c01=clz.getDeclaredConstructor(null);
			Constructor c02=clz.getDeclaredConstructor(int.class,String.class,int.class);
			System.out.println(c02);
			for(Constructor temp:constructors){
				System.out.println("构造器："+temp);
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
