package com.xj.gen02;

/**
 * ���͵Ĳ�����ʹ��|ʵ��|�̳� û��ָ������
 * ������Object������ͬObject
 * @author Administrator
 *
 */
public class Simple {
	public static void main(String[] args) {
		//���͵Ĳ���--��û��ָ�����͵ľ�������
		Student stu=new Student();
		stu.setJavase(100);//100-->int-->Integer �Զ�װ��
		Object obj=stu.getJavase();
		
		
		test(stu);//��ָ��ʱ�����벻�����ͼ��
		Student<Object>stu2=new Student<Object>();//ָ��ʱ����������ͼ��
//		������Object
//		test(stu2);
	}
	
	public static void test(Student<Integer> stu){
		
	}
}
