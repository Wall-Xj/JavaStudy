package com.xj.memento;
/**
 * ����¼ģʽ
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		CareTaker taker=new CareTaker();
		Emp e=new Emp("tom", 20, 10000);
		System.out.println("��һ��:"+e.toString());
		
		taker.setMemento(e.memento());
		
		e.setAge(30);
		e.setEname("jack");
		e.setSalary(3000);
		System.out.println("�ڶ���:"+e.toString());
		
		e.recovery(taker.getMemento());
		System.out.println("������:"+e.toString());
		
		
	}
}
