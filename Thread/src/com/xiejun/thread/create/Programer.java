package com.xiejun.thread.create;
/**
 * 使用Runnable 创建线程
 * 	1、类 实现Runnable接口+重写run()方法=====》真是角色类
 * 	2、启动多线程 使用静态代理
 * 		1）、创建真实角色
 * 		2）、创建代理角色+真实角色引用
 * 		3）、调用.start()方法  启动线程
 * @author Administrator
 *
 */
public class Programer implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("黑色的黑色");
		}
		
	}


}
