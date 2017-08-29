package com.xj.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xj.spring.helloworld.HelloWorld;
import com.xj.spring.helloworld.HelloWorldService;

public class HelloProgram {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");

		HelloWorld hw = service.getHelloWorld();

		hw.sayHello();
	}
}