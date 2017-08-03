package com.xiejun.thread.info;
/**
 * 优先级：概率，不是绝对的优先级
 * MAX_PRIORITY 10
 * MIN_PRIORITY  1
 * NORM_PRIORITY 5（默认）
 * setPriority()
 * getPriority()
 * @author Administrator
 *
 */
public class InfoDemo02 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyThread t1=new MyThread();
		Thread p1=new Thread(t1,"放大");
		MyThread t2=new MyThread();
		Thread p2=new Thread(t2,"缩小");
		p1.setPriority(Thread.MIN_PRIORITY);
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start();
		Thread.sleep(50);
		t1.stop();
		t2.stop();
	}

}
