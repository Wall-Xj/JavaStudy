package com.xj.gen01;

/**
 * 自定义泛型类
 * @author Administrator
 *
 * @param <E>
 */
public class Student<T> {
	private T javase;
	
	public Student() {
		super();
	}
	
	public Student(T javase) {
		super();
		this.javase = javase;
	}

	public T getJavase() {
		return javase;
	}

	public void setJavase(T javase) {
		this.javase = javase;
	}


	
}
