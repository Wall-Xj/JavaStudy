package com.xiejun.thread.create;

public class ProgrammerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //1����������ʵ��ɫ
		Programer pro=new Programer();
		 //2�������������ɫ+��ʵ��ɫ����
		Thread proxy=new Thread(pro);
		 //3��������.start()����  �����߳�
		proxy.start();
		for(int i=0;i<100;i++){
			System.out.println("��ɫ�İ�ɫ");
		}
	}

}
