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
		System.out.println(Thread.currentThread().getName() + "==>����:"
				+ Jvm.getInstance(time));
	}
}

/**
 * �������ģʽ ȷ��һ����ֻ��һ������ ����ʽ 1��������˽�л��������ⲿֱ�Ӵ������� 2������һ��˽�еľ�̬���� 3������һ������Ĺ����ľ�̬����
 * ���ʸñ������������û�ж��󣬴����ö���
 * 
 * @author Administrator
 * 
 */
class Jvm {
	// ����һ��˽�еľ�̬����
	private static Jvm instance = null;

	// ������˽�л��������ⲿֱ�Ӵ�������
	private Jvm() {

	}

	// ����һ������Ĺ����ľ�̬���� ���ʸñ������������û�ж��󣬴����ö���
	public static Jvm getInstance(long time) {
		//���Ч��
		if (instance == null) {
			synchronized (Jvm.class) {
				if (instance == null) {
					try {
						Thread.sleep(500);// ��ʱ ��������
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
		// Ч�ʲ��� ���ڶ���Ҳ��Ҫ�ȴ�
		synchronized (Jvm.class) {
			if (instance == null) {
				try {
					Thread.sleep(500);// ��ʱ ��������
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
				Thread.sleep(500);// ��ʱ ��������
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
				Thread.sleep(500);// ��ʱ ��������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
}