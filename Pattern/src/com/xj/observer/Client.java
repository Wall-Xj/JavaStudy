package com.xj.observer;
/**
 * �۲���ģʽ
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		//Ŀ�����
		ConcreteSubject subject=new ConcreteSubject();
		
		//��������۲���
		ConcreteObserver a=new ConcreteObserver();
		ConcreteObserver b=new ConcreteObserver();
		ConcreteObserver c=new ConcreteObserver();
		
		
		subject.registerObserver(a);
		subject.registerObserver(b);
		subject.registerObserver(c);
		
		subject.setState(100);
		
		System.out.println(a.getMyState());
		System.out.println(b.getMyState());
		System.out.println(c.getMyState());
	}
}
