package com.xj.templateMethod;

public abstract class BanfkTemplateMethod {
	public void takeNumber() {
		System.out.println("取号排队");
	}

	public abstract void transact();// 办理具体的业务 钩子方法

	public void evaluate() {
		System.out.println("反馈评价");
	}

	public final void process() {//模版方法
		this.takeNumber();
		this.transact();
		this.evaluate();
	}
}
