package com.xj.decorator;

/**
 * 抽象构件
 * @author WanYin
 *
 */
public interface ICar {
	void move();
}

/**
 * ConcreteComponent  具体构建对象（真实对象）
 * @author WanYin
 *
 */
class Car implements ICar{
	@Override
	public void move() {
		System.out.println("跑");	
	}
}

/**
 * Decorator 装饰角色
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
 * ConcreteDecorator 具体装饰角色
 * @author WanYin
 *
 */
class FlyCar extends SuperCar{
	public FlyCar(ICar car) {
		super(car);
	}
	
	public void fly(){
		System.out.println("飞");
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
		System.out.println("游");
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
		System.out.println("自动跑");
	}

	@Override
	public void move() {
		super.move();
		auto();
	}
}

