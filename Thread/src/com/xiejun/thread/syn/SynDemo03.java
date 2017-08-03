package com.xiejun.thread.syn;
/**
 * 过多的同步方法肯呢个造成死锁
 * @author Administrator
 *
 */
public class SynDemo03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object g=new Object();
		Object m=new Object();
		Test t1=new Test(g,m);
		Test2 t2=new Test2(g,m);
		Thread proxy1=new Thread(t1);
		Thread proxy2=new Thread(t2);
		proxy1.start();
		proxy2.start();
	}

}

class Test implements Runnable{
	Object goods;
	Object money;
	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true){
			test();
		}
		
	}
	
	private void test(){
		synchronized(goods){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(money){
				
			}
		}
		System.out.println("一手交钱");
	}
}

class Test2 implements Runnable{
	Object goods;
	Object money;
	public Test2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true){
			test();
		}
		
	}
	
	private void test(){
		synchronized(money){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(goods){
				
			}
		}
		System.out.println("一手交货");
	}
}
