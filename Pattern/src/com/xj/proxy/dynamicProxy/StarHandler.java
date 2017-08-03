package com.xj.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {

	private Star realStar;
	
	
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj=null;
		
		
		if(method.getName().toLowerCase().equals("sing")){
			obj=method.invoke(realStar, args);
		}
	
		
		return obj;
	}
	
}
