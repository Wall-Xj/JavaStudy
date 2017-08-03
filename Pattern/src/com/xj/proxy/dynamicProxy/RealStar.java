package com.xj.proxy.dynamicProxy;

public class RealStar implements Star {

	@Override
	public void confer() {
		System.out.println("RealStar.confer()");
		
	}

	@Override
	public void singContract() {
		System.out.println("RealStar.singContract()");
		
	}

	@Override
	public void bookTicket() {
		System.out.println("RealStar.bookTicket()");
	}

	@Override
	public void sing() {
		System.out.println("RealStar.sing()");
	}

	@Override
	public void collectMoney() {
		System.out.println("RealStar.collectMoney()");
	}
	
}
