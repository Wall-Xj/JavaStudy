package com.xj.decorator;
/**
 * 装饰模式
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		ICar car=new Car();
		car.move();
		
		System.out.println("增加新功能：飞");
		FlyCar flyCar=new FlyCar(car);
		flyCar.move();
		
		System.out.println("增加新功能：游");
		WaterCar waterCar=new WaterCar(car);
		waterCar.move();
		
		System.out.println("增加多个新功能：");
		AICar aiCar=new AICar(new FlyCar(new Car()));
		aiCar.move();
	}
}
