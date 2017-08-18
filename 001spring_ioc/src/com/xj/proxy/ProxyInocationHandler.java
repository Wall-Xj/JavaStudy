package com.xj.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInocationHandler implements InvocationHandler {
	private Object target;//目标对象  真实对象
	public void setTarget(Object target) {
		this.target = target;
	}
	/**
	 * 生成代理类
	 * @return
	 */
	public Object getProxy() {
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.log(method.getName());
		Object result=method.invoke(target, args);
		return null;
	}

	public void log(String method) {
		System.out.println("执行:"+method+"方法");
	}
	
}
