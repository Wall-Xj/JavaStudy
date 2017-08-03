package com.xj.memento;
/**
 * 备忘录模式
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		CareTaker taker=new CareTaker();
		Emp e=new Emp("tom", 20, 10000);
		System.out.println("第一次:"+e.toString());
		
		taker.setMemento(e.memento());
		
		e.setAge(30);
		e.setEname("jack");
		e.setSalary(3000);
		System.out.println("第二次:"+e.toString());
		
		e.recovery(taker.getMemento());
		System.out.println("第三次:"+e.toString());
		
		
	}
}
