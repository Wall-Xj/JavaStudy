package com.xj.observer2;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject subject=new ConcreteSubject();
		ObserverA a=new ObserverA();
		ObserverA b=new ObserverA();
		ObserverA c=new ObserverA();
		
		subject.addObserver(c);
		subject.addObserver(b);
		subject.addObserver(a);
		
		subject.set(1321);
		
		System.out.println(a.getMyState());
		System.out.println(b.getMyState());
		System.out.println(c.getMyState());
	}
}
