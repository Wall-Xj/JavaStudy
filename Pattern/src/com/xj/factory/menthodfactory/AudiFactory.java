package com.xj.factory.menthodfactory;

public class AudiFactory implements CarFactory {
	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}
}
