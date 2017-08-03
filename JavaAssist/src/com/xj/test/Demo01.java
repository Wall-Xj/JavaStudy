package com.xj.test;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

public class Demo01 {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		// TODO Auto-generated method stub
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.makeClass("com.xj.bean.Emp");
		
		//创建属性
		CtField f1=CtField.make("private int empno;", cc);
		CtField f2=CtField.make("private String ename;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		//创建方法
		CtMethod m1=CtMethod.make("public int getEmpno(){return empno;}", cc);
		CtMethod m2=CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//创建构造器
		CtConstructor constructor=new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
		constructor.setBody("{this.empno=empno;this.ename=ename;}");
		cc.addConstructor(constructor);
		
		cc.writeFile("e:/myjava");
		
		System.out.println("创建完成");
	}
}
