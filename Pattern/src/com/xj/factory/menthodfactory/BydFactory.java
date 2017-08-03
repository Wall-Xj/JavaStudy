package com.xj.factory.menthodfactory;

public class BydFactory implements CarFactory {
	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return new Byd();
	}
}
