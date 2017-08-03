package com.xiejun.thread.syn;
/**
 * 单例创建的方式
 * 1、懒汉式
 * 1）、构造器私有化
 * 2）、声明私有的静态属性
 * 3）、对外提供访问属性的静态方法，确保该对象存在
 * @author Administrator
 *
 */
public class MyJvm {
	private static MyJvm instance;
	private MyJvm() {
		
	}
	public static MyJvm getInstance(){
		if(null==instance){
			synchronized(MyJvm.class){
				if(null==instance){
					instance=new MyJvm();
				}
			}
		}
		return instance;
	}

}
/**
 * 单例创建的方式
 * 1、饿汉式
 * 1）、构造器私有化
 * 2）、声明私有的静态属性，同时创建该对象
 * 3）、对外提供访问属性的静态方法
 * @author Administrator
 *
 */
class MyJvm1 {
	private static MyJvm1 instance=new MyJvm1();
	private MyJvm1() {
		
	}
	public static MyJvm1 getInstance(){
		return instance;
	}

}
/**
 * 类在使用的时候加载，延缓了加载时间
 * 
 * @author Administrator
 *
 */
class MyJvm2 {
	private static class JvmHolder{
	private static MyJvm2 instance=new MyJvm2();
	}
	private MyJvm2() {
		
	}
	public static MyJvm2 getInstance(){
		return JvmHolder.instance;
	}

}