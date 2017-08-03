package com.xj.singlegon;

import java.util.concurrent.CountDownLatch;

public class Client03 {
	public static void main(String[] args) throws Exception {
		
		long start =System.currentTimeMillis();
		
		int threadCount=10;
		final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		
		for(int i=0;i<threadCount;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int j=0;j<100000;j++){
						Object o=Demo01.getInstance();
					}
					
					countDownLatch.countDown();
				}
			}).start();
		}
		
		countDownLatch.await();//main线程阻塞，知道计数器变为0
		
		long end =System.currentTimeMillis();
		
		System.out.println("总耗时："+(end-start));
	}
}
