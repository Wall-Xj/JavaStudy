package com.xiejun.thread.pro;
/**
 * ��ͬ����Դ
 * ������������ģʽ �źŵƷ�
 * wait() :�ȴ����ͷ��� sleep() ���ͷ���
 * notify()/notifyAll():����
 * ��synchronizedһ��ʹ��
 * @author Administrator
 *
 */
public class Movie {
	private String pic;
	//�źŵ�
	//true--�����������������ߵȴ���������ɺ�֪ͨ������
	//false--���������ѣ������ߵȴ����������֪ͨ������
	private boolean flag=true;
	public synchronized void play(String pic){
		if(!flag){//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�������
		this.pic=pic;
		//֪ͨ����
		this.notify();
		//������ͣ��
		this.flag=false;
	}

	public synchronized void watch(){
		if(flag){//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pic);
		//�������
		//֪ͨ����
		this.notifyAll();
		//����ֹͣ
		this.flag=true;
	}
}
