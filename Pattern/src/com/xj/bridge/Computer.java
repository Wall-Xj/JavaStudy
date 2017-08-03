package com.xj.bridge;

public class Computer {
	
	protected Brand brand;

	public Computer(Brand brand) {
		super();
		this.brand = brand;
	}
	
	public void sale(){
		brand.sale();
	}
}

class desktop extends Computer{

	public desktop(Brand brand) {
		super(brand);
	}
	@Override
	public void sale() {
		super.sale();
		System.out.println("����̨ʽ��");
	}
}

class Laptop extends Computer{

	public Laptop(Brand brand) {
		super(brand);
	}
	@Override
	public void sale() {
		super.sale();
		System.out.println("���۱ʼǱ�");
	}
}
