package com.xj.log;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;

@Aspect
public class Log  {
	
	@Before("execution(* com.xj.service.UserServiceImpl.*(..))")
	public void before() {
		System.out.println("执行前");
	}
	@After("execution(* com.xj.service.UserServiceImpl.*(..))")
	public void after() {
		System.out.println("执行后");
	}
	@Around("execution(* com.xj.service.UserServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		
		System.out.println("环绕前");
		System.out.println("签名："+point.getSignature());
		Object result=point.proceed();
		System.out.println("环绕后");
		return result;
		
	}
}
