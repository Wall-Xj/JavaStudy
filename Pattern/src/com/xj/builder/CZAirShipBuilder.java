package com.xj.builder;

public class CZAirShipBuilder implements AirShipBuilder {

	@Override
	public Engine createEngine() {
		System.out.println("��������������");
		return new Engine("����������");
	}

	@Override
	public OrbitalModule createOrbitalModulle() {
		System.out.println("�������������");
		return new OrbitalModule("���������");
	}

	@Override
	public EscapeTower createEscapeTower() {
		System.out.println("��������������");
		return new EscapeTower("����������");
	}

}
