package com.xj.gen01;

/**
 * �Զ��巺�����ʹ�ã�
 * ������ʱָ������
 * ����Ϊ�������ͣ�ֻ��Ϊ��������
 * @author Administrator
 *
 */
public class Simple {
	public static void main(String[] args) {
		Student<Integer>stu=new Student<Integer>();
		stu.setJavase(123);
		Integer score=stu.getJavase();
		System.out.println(score);
	}
}
