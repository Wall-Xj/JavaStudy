package com.xj.builder;

public class CZAirShipBuilder implements AirShipBuilder {

	@Override
	public Engine createEngine() {
		System.out.println("构建长征发动机");
		return new Engine("长征发动机");
	}

	@Override
	public OrbitalModule createOrbitalModulle() {
		System.out.println("构建长征轨道舱");
		return new OrbitalModule("长征轨道舱");
	}

	@Override
	public EscapeTower createEscapeTower() {
		System.out.println("构建长征逃生塔");
		return new EscapeTower("长征逃生塔");
	}

}
