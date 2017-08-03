package com.xj.decorator;
/**
 * װ��ģʽ
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		ICar car=new Car();
		car.move();
		
		System.out.println("�����¹��ܣ���");
		FlyCar flyCar=new FlyCar(car);
		flyCar.move();
		
		System.out.println("�����¹��ܣ���");
		WaterCar waterCar=new WaterCar(car);
		waterCar.move();
		
		System.out.println("���Ӷ���¹��ܣ�");
		AICar aiCar=new AICar(new FlyCar(new Car()));
		aiCar.move();
	}
}
