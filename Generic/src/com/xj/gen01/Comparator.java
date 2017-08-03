package com.xj.gen01;

/**
 * 泛型接口
 * 泛型不能用在全局常量上
 * @author Administrator
 *
 * @param <T>
 */
public interface Comparator<T> {
	//全局常量
	/*public static final*/ int MAX_VALUE=1024;
	//公共的抽象方法
	/*public abstract*/ void compare(T t);
}
