package com.xj.strategy;

public class OldCustomerManyStrategy implements Strategy {

	@Override
	public double getPerice(double standardPerice) {
		System.out.println("��8��");
		return standardPerice*0.8;
	}
	
}
