package com.xj.gen02;

/**
 * 泛型的擦除：使用|实现|继承 没有指定类型
 * 类似与Object，不等同Object
 * @author Administrator
 *
 */
public class Simple {
	public static void main(String[] args) {
		//泛型的擦除--》没有指定泛型的具体类型
		Student stu=new Student();
		stu.setJavase(100);//100-->int-->Integer 自动装箱
		Object obj=stu.getJavase();
		
		
		test(stu);//不指定时，编译不会类型检查
		Student<Object>stu2=new Student<Object>();//指定时，编译会类型检查
//		不等于Object
//		test(stu2);
	}
	
	public static void test(Student<Integer> stu){
		
	}
}
