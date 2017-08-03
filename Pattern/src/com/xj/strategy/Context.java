package com.xj.strategy;

public class Context {
	private Strategy strategy;

	// 通过构造器注入
	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	// 通过set()方法注入
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void pringPerice(double s) {
		System.out.println("报价：" + strategy.getPerice(s));
	}
}
