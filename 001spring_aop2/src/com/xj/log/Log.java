package com.xj.log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class Log  {

	public void before() {
		System.out.println("执行前");
	}
	
	public void after() {
		System.out.println("执行后");
	}
}
