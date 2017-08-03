package com.xiejun.thread.syn;

public class SynDemo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JvmThread jvm1 = new JvmThread(100);
		JvmThread jvm2 = new JvmThread(500);
		jvm1.start();
		jvm2.start();
	}

}

class JvmThread extends Thread {
	private long time;

	public JvmThread() {

	}

	public JvmThread(long time) {
		this.time = time;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "==>创建:"
				+ Jvm.getInstance(time));
	}
}

/**
 * 单例设计模式 确保一个类只有一个对象 懒汉式 1、构造器私有化，避免外部直接创建对象 2、声明一个私有的静态变量 3、创建一个对外的公共的静态方法
 * 访问该变量，如果变量没有对象，创建该对象
 * 
 * @author Administrator
 * 
 */
class Jvm {
	// 声明一个私有的静态变量
	private static Jvm instance = null;

	// 构造器私有化，避免外部直接创建对象
	private Jvm() {

	}

	// 创建一个对外的公共的静态方法 访问该变量，如果变量没有对象，创建该对象
	public static Jvm getInstance(long time) {
		//提高效率
		if (instance == null) {
			synchronized (Jvm.class) {
				if (instance == null) {
					try {
						Thread.sleep(500);// 延时 方法错误
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();
				}

			}
		}
		return instance;
	}

	public static Jvm getInstance3(long time) {
		// 效率不高 存在对象也需要等待
		synchronized (Jvm.class) {
			if (instance == null) {
				try {
					Thread.sleep(500);// 延时 方法错误
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}
			return instance;
		}
	}

	public static synchronized Jvm getInstance2(long time) {
		if (instance == null) {
			try {
				Thread.sleep(500);// 延时 方法错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}

	public static Jvm getInstance1(long time) {
		if (instance == null) {
			try {
				Thread.sleep(500);// 延时 方法错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
}