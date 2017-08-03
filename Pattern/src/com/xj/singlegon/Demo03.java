package com.xj.singlegon;

public class Demo03 {
	
	//静态内部类实现单例模式
	private static class SingletonClassInstance {
		private static final Demo03 demo= new Demo03();
	}
	
	private Demo03(){
		
	}
	
	//方法未同步，调用效率高
	public static Demo03 getInstance(){
		return SingletonClassInstance.demo;
	}
	
}
