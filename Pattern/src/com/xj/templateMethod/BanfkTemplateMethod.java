package com.xj.templateMethod;

public abstract class BanfkTemplateMethod {
	public void takeNumber() {
		System.out.println("ȡ���Ŷ�");
	}

	public abstract void transact();// ��������ҵ�� ���ӷ���

	public void evaluate() {
		System.out.println("��������");
	}

	public final void process() {//ģ�淽��
		this.takeNumber();
		this.transact();
		this.evaluate();
	}
}
