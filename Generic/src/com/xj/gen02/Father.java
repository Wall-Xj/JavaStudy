package com.xj.gen02;

/**
 * ���͸��࣬����Ϊ������
 * 1���������෺��--������Ϊ����
 * 2�����������෺��--�����ఴ��ʵ��
 * 
 * ���Լ�����������==����λ�ö���
 * ��1���������д��������--���游�����
 * ������������������==�����Լ�����
 * ��2��������ʹ�ø��������--���游�����
 * ������ʹ���Լ�������==�����Լ�����
 * 
 * @author Administrator
 *
 */
public abstract class Father<T1,T2> {
	T1 age;
	public abstract void test(T2 name);
}

//���� -->��������
//��1����ȫ���� 
class C1<T1,T2,T3>extends Father<T1,T2>{
	T3 sex;
	@Override
	public void test(T2 name) {
//		this.age -->T1
	}
	
	public void test2(T3 name){
		
	}
	
}
//��2�������ֱ���
class C2<T2> extends Father<Integer,T2>{

	@Override
	public void test(T2 name) {
//		this.age -->Integer
	}
	
}

//������ -->����ʵ��
//��1������������
class C3 extends Father<Integer,String>{

	@Override
	public void test(String name) {
//		this.age -->Integer
	}
	
}
//��2����û������ ����Object
class C4 extends Father<Object,Object>{

	@Override
	public void test(Object name) {
//		this.age -->Object
	}
	
}
