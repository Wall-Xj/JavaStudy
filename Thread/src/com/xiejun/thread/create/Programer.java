package com.xiejun.thread.create;
/**
 * ʹ��Runnable �����߳�
 * 	1���� ʵ��Runnable�ӿ�+��дrun()����=====�����ǽ�ɫ��
 * 	2���������߳� ʹ�þ�̬����
 * 		1����������ʵ��ɫ
 * 		2�������������ɫ+��ʵ��ɫ����
 * 		3��������.start()����  �����߳�
 * @author Administrator
 *
 */
public class Programer implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("��ɫ�ĺ�ɫ");
		}
		
	}


}
