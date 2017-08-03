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
		System.out.println("ÅÜÒµÎñ");
	}

	@Override
	public void outAction() {
		System.out.println("ÉêÇëÇ®");
		m.command("finacial");
	}
	
}
