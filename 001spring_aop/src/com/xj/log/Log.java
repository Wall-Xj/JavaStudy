package com.xj.log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class Log implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println(target.getClass()+"的"+method.getName()+"方法被执行");
		
	}
	
}
