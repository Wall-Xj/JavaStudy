package com.xj.strategy;

public class NewCustomerFewStrategy implements Strategy {

	@Override
	public double getPerice(double standardPerice) {
		System.out.println("≤ª¥Ú’€");
		return standardPerice;
	}
	
}
