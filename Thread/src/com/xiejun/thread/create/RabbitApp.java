package com.xiejun.thread.create;

public class RabbitApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�����������
		Rabbit rab=new Rabbit();
		Tortoise tor=new Tortoise();
		//����start()����
		rab.start();
		tor.start();
		
	}

}
