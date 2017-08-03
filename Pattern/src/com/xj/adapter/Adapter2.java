package com.xj.adapter;
/**
 * ¶ÔÏóÊÊÅäÆ÷
 * @author WanYin
 *
 */
public class Adapter2 implements Target {
	
	private Adaptee a;
	
	public Adapter2(Adaptee a) {
		super();
		this.a = a;
	}

	@Override
	public void handleReq() {
		a.request();
	}
}
