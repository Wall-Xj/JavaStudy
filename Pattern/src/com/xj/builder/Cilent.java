package com.xj.builder;
/**
 * 建造模式
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
