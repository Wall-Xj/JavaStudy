package com.xj.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class Demo02 {
	
	public static void test01() throws Exception{
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("com.xj.test.Emp");
		
		byte[] bytes=cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		
		System.out.println(cc.getSimpleName());
		System.out.println(cc.getSuperclass());
		System.out.println(cc.getInterfaces());
		
	}
	
	public static void test02() throws Exception{
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.getCtClass("com.xj.test.Emp");
		
//		CtMethod m=CtMethod.make("public int add(int a,int b){return a+b}", cc);
		
		CtMethod m = new CtMethod(CtClass.intType,"add",
				new CtClass[]{CtClass.intType,CtClass.intType},cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.println(\"test\");return $1+$2;}");
		
		cc.addMethod(m);
		
		//反射调用新生成的方法
		Class clazz=cc.toClass();
		Object obj=clazz.newInstance();//通过调用Emp的无参构造器，创建到Emp对象
		Method method=clazz.getDeclaredMethod("add", int.class,int.class);
		Object result=method.invoke(obj,100, 200);
		System.out.println(result);
		
	}
	
	
	public static void main(String[] args) throws Exception {
		test02();	
	}
}
