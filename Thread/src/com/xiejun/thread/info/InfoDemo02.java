package com.xiejun.thread.info;
/**
 * ���ȼ������ʣ����Ǿ��Ե����ȼ�
 * MAX_PRIORITY 10
 * MIN_PRIORITY  1
 * NORM_PRIORITY 5��Ĭ�ϣ�
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
		Thread p1=new Thread(t1,"�Ŵ�");
		MyThread t2=new MyThread();
		Thread p2=new Thread(t2,"��С");
		p1.setPriority(Thread.MIN_PRIORITY);
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start();
		Thread.sleep(50);
		t1.stop();
		t2.stop();
	}

}
