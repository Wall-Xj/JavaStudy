package com.xj.others.que;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ʹ�ö���ʵ���Զ����ջ
 * 1����ջ
 * 2��ѹջ
 * 3����ȡͷ
 * @author Administrator
 *
 * @param <E>
 */
public class MyStack<E> {
	private Deque<E>container=new ArrayDeque<E>();
	private int cap;
	
	public MyStack(int cap) {
		super();
		this.cap = cap;
	}
	
	public boolean push(E e){
		if(container.size()+1>cap){
			return false;
		}
		return container.offerLast(e);
	}
	
	public E pop(){
		return container.pollLast();
	}
	
	public E peek(){
		return container.peekLast();
	}
	
	public int size(){
		return this.container.size();
	}
}
