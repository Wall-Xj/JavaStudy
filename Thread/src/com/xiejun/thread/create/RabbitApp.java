package com.xiejun.thread.create;

public class RabbitApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建子类对象
		Rabbit rab=new Rabbit();
		Tortoise tor=new Tortoise();
		//调用start()方法
		rab.start();
		tor.start();
		
	}

}
