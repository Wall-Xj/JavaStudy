package com.xj.observer;
/**
 * 观察者模式
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		//目标对象
		ConcreteSubject subject=new ConcreteSubject();
		
		//创建多个观察者
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
