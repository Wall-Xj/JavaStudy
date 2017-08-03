package com.xj.factory.simplefactory;

public class Client01 {
	public static void main(String[] args) {
		Audi audi=new Audi();
		Byd byd=new Byd();
		
		audi.run();
		byd.run();
	}
}
