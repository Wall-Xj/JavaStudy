package com.xj.state;

public class Context {
	private State state;

	public void setState(State s) {
		this.state = s;
		System.out.println("�޸�״̬");
		state.handle();
	}
}
