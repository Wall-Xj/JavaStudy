package com.xj.strategy;

public class OldCustomerFewStrategy implements Strategy {

	@Override
	public double getPerice(double standardPerice) {
		System.out.println("�������");
		return standardPerice*0.85;
	}
	
}
