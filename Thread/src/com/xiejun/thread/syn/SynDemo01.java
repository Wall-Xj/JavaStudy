package com.xiejun.thread.syn;

public class SynDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Web12306 web = new Web12306();
		Thread t1 = new Thread(web, "路人甲");
		Thread t2 = new Thread(web, "黄牛乙");
		Thread t3 = new Thread(web, "工程师");
		t1.start();
		t2.start();
		t3.start();
	}

}

class Web12306 implements Runnable {
	private int num = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test5();
		}

	}

	// 锁定范围不正确
	public void test5() {
		synchronized ((Integer) num) {
			if (num <= 0) {
				flag = false;
				return;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out
					.println(Thread.currentThread().getName() + "抢到了" + num--);
		}
	}

	// 锁定范围不正确
	public void test4() {
		synchronized (this) {
			if (num <= 0) {
				flag = false;
				return;
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);

	}

	// 线程安全
	public void test3() {
		synchronized (this) {
			if (num <= 0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out
					.println(Thread.currentThread().getName() + "抢到了" + num--);
		}
	}

	// 线程安全
	public synchronized void test2() {
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
	}

	// 线程不安全
	public void test1() {
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
	}

}