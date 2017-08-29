package com.xj.spring.helloworld.impl;

import com.xj.spring.helloworld.HelloWorld;

public class StrutsHelloWorld implements HelloWorld {
	  
    @Override
    public void sayHello() {
        System.out.println("Struts Say Hello!!");
    }
  
}