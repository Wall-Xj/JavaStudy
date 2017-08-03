package com.xj.builder;
/**
 * ����ģʽ
 * @author WanYin
 *
 */
public class Cilent {
	public static void main(String[] args) {
		AirShipDirector director=new CZAirShipDirector(new CZAirShipBuilder());
		AirShip ship=director.directorAirShip();
		System.out.println(ship.getClass().getName());
		System.out.println(ship.getEngine().getName());
		ship.launch();
	}
}
