package com.xiejun.thread.info;
/**
 * Thread.currentThread()
 * setName()
 * getName()
 * isAlive()
 * @author Administrator
 *
 */
public class InfoDemo01 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyThread t1=new MyThread();
		Thread proxy=new Thread(t1,"放大");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());
		proxy.start();
		System.out.println("启动后的状态："+proxy.isAlive());
		Thread.sleep(20);
		t1.stop();
		Thread.sleep(100);
		System.out.println("停止后的状态："+proxy.isAlive());
	}

}
