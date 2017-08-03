package com.xj.strategy;

public class Context {
	private Strategy strategy;

	// ͨ��������ע��
	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	// ͨ��set()����ע��
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void pringPerice(double s) {
		System.out.println("���ۣ�" + strategy.getPerice(s));
	}
}
