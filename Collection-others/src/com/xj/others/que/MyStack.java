package com.xj.others.que;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用队列实现自定义堆栈
 * 1、弹栈
 * 2、压栈
 * 3、获取头
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
