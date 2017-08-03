package com.xiejun.thread.status;

public class YieldDemo01 extends Thread{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		YieldDemo01 demo=new YieldDemo01();
		Thread t=new Thread(demo);
		t.start();
		
		for(int i=0;i<100;i++){
			if(i%20==0){
				//ÔÝÍ£±¾Ïß³Ì main
				Thread.yield();
			}
			System.out.println("main...."+i);
		}
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("join...."+i);
		}
			
	}
}
