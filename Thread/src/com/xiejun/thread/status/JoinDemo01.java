package com.xiejun.thread.status;

public class JoinDemo01 extends Thread {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 demo=new JoinDemo01();
		Thread t=new Thread(demo);
		t.start();
		
		for(int i=0;i<100;i++){
			if(i==50){
				t.join();
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
