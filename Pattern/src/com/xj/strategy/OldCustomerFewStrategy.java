package com.xj.strategy;

public class OldCustomerFewStrategy implements Strategy {

	@Override
	public double getPerice(double standardPerice) {
		System.out.println("´ò°ËÎåÕÛ");
		return standardPerice*0.85;
	}
	
}
