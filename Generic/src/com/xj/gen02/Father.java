package com.xj.gen02;

/**
 * 泛型父类，子类为富二代
 * 1、保留父类泛型--》子类为泛型
 * 2、不保留父类泛型--》子类按需实现
 * 
 * 属性及方法的类型==》随位置而定
 * （1）子类的重写方法类型--》随父类而定
 * 子类新增方法的类型==》随自己而定
 * （2）子类中使用父类的属性--》随父类而定
 * 子类中使用自己的类型==》随自己而定
 * 
 * @author Administrator
 *
 */
public abstract class Father<T1,T2> {
	T1 age;
	public abstract void test(T2 name);
}

//保留 -->泛型子类
//（1）、全保留 
class C1<T1,T2,T3>extends Father<T1,T2>{
	T3 sex;
	@Override
	public void test(T2 name) {
//		this.age -->T1
	}
	
	public void test2(T3 name){
		
	}
	
}
//（2）、部分保留
class C2<T2> extends Father<Integer,T2>{

	@Override
	public void test(T2 name) {
//		this.age -->Integer
	}
	
}

//不保留 -->按需实现
//（1）、具体类型
class C3 extends Father<Integer,String>{

	@Override
	public void test(String name) {
//		this.age -->Integer
	}
	
}
//（2）、没有类型 擦除Object
class C4 extends Father<Object,Object>{

	@Override
	public void test(Object name) {
//		this.age -->Object
	}
	
}
