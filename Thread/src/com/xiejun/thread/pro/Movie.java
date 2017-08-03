package com.xiejun.thread.pro;
/**
 * 共同的资源
 * 生产者消费者模式 信号灯法
 * wait() :等待，释放锁 sleep() 不释放锁
 * notify()/notifyAll():唤醒
 * 与synchronized一起使用
 * @author Administrator
 *
 */
public class Movie {
	private String pic;
	//信号灯
	//true--生产者生产，消费者等待，生产完成后通知消费者
	//false--消费者消费，生产者等待，消费完后通知生产者
	private boolean flag=true;
	public synchronized void play(String pic){
		if(!flag){//生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//生产完毕
		this.pic=pic;
		//通知消费
		this.notify();
		//生产者停下
		this.flag=false;
	}

	public synchronized void watch(){
		if(flag){//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pic);
		//消费完毕
		//通知生产
		this.notifyAll();
		//消费停止
		this.flag=true;
	}
}
