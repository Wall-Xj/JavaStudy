package com.xiejun.thread.syn;
/**
 * ���������ķ�ʽ
 * 1������ʽ
 * 1����������˽�л�
 * 2��������˽�еľ�̬����
 * 3���������ṩ�������Եľ�̬������ȷ���ö������
 * @author Administrator
 *
 */
public class MyJvm {
	private static MyJvm instance;
	private MyJvm() {
		
	}
	public static MyJvm getInstance(){
		if(null==instance){
			synchronized(MyJvm.class){
				if(null==instance){
					instance=new MyJvm();
				}
			}
		}
		return instance;
	}

}
/**
 * ���������ķ�ʽ
 * 1������ʽ
 * 1����������˽�л�
 * 2��������˽�еľ�̬���ԣ�ͬʱ�����ö���
 * 3���������ṩ�������Եľ�̬����
 * @author Administrator
 *
 */
class MyJvm1 {
	private static MyJvm1 instance=new MyJvm1();
	private MyJvm1() {
		
	}
	public static MyJvm1 getInstance(){
		return instance;
	}

}
/**
 * ����ʹ�õ�ʱ����أ��ӻ��˼���ʱ��
 * 
 * @author Administrator
 *
 */
class MyJvm2 {
	private static class JvmHolder{
	private static MyJvm2 instance=new MyJvm2();
	}
	private MyJvm2() {
		
	}
	public static MyJvm2 getInstance(){
		return JvmHolder.instance;
	}

}