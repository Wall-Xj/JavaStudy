package com.xj.spring.helloworld.impl;

import com.xj.spring.helloworld.HelloWorld;

public class SpringHelloWorld implements HelloWorld {
	  
    @Override
    public void sayHello() {
        System.out.println("Spring Say Hello!!");
    }
  
}