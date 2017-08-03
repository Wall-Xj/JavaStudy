package com.xj.factory.simplefactory;

public class Client02 {
	public static void main(String[] args) {
		Car audi=CarFactory.createCar("audi");
		Car byd=CarFactory.createCar("byd");
		
		audi.run();
		byd.run();
	}

}
