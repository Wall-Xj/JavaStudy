package com.xj.decorator;

/**
 * ���󹹼�
 * @author WanYin
 *
 */
public interface ICar {
	void move();
}

/**
 * ConcreteComponent  ���幹��������ʵ����
 * @author WanYin
 *
 */
class Car implements ICar{
	@Override
	public void move() {
		System.out.println("��");	
	}
}

/**
 * Decorator װ�ν�ɫ
 * @author WanYin
 *
 */
class SuperCar implements ICar{
	protected ICar car;
	
	public SuperCar(ICar car) {
		super();
		this.car = car;
	}


	@Override
	public void move() {
		car.move();
	}
}
/**
 * ConcreteDecorator ����װ�ν�ɫ
 * @author WanYin
 *
 */
class FlyCar extends SuperCar{
	public FlyCar(ICar car) {
		super(car);
	}
	
	public void fly(){
		System.out.println("��");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
}

class WaterCar extends SuperCar{
	public WaterCar(ICar car) {
		super(car);
	}
	
	public void swin(){
		System.out.println("��");
	}

	@Override
	public void move() {
		super.move();
		swin();
	}
}

class AICar extends SuperCar{
	public AICar(ICar car) {
		super(car);
	}
	
	public void auto(){
		System.out.println("�Զ���");
	}

	@Override
	public void move() {
		super.move();
		auto();
	}
}

