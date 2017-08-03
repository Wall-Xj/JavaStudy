package com.xiejun.thread.create;

public class ProgrammerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //1）、创建真实角色
		Programer pro=new Programer();
		 //2）、创建代理角色+真实角色引用
		Thread proxy=new Thread(pro);
		 //3）、调用.start()方法  启动线程
		proxy.start();
		for(int i=0;i<100;i++){
			System.out.println("白色的白色");
		}
	}

}
