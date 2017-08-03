package com.xj.mediator;

public class Market implements Department {

	private Mediator m;
	
	public Market(Mediator m) {
		super();
		this.m = m;
		m.register("market", this);
	}

	@Override
	public void selfAction() {
		System.out.println("��ҵ��");
	}

	@Override
	public void outAction() {
		System.out.println("����Ǯ");
		m.command("finacial");
	}
	
}
