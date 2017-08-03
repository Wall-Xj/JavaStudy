package com.xj.gen02;

/**
 * 泛型接口与泛型类同理
 * 
 * @author Administrator
 * 
 */
public interface Comparator<T> {
	// 全局常量
	public static final int MAX_VALUE = 100;

	// 公共抽象方法
	public abstract void test(T t);

}

class InterC1<A> implements Comparator {

	@Override
	public void test(Object t) {

	}
}

class InterC2<A> implements Comparator<Integer> {

	@Override
	public void test(Integer t) {

	}
}

class InterC3<T, A> implements Comparator<T> {

	@Override
	public void test(T t) {

	}
}