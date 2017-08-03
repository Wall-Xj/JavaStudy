package com.xj.builder;

public class CZAirShipDirector implements AirShipDirector {

	private AirShipBuilder builder;
	
	
	public CZAirShipDirector(AirShipBuilder builder) {
		super();
		this.builder = builder;
	}


	@Override
	public AirShip directorAirShip() {
		
		Engine e=builder.createEngine();
		OrbitalModule o=builder.createOrbitalModulle();
		EscapeTower et=builder.createEscapeTower();
		
		AirShip ship=new AirShip();
		ship.setEacapeTower(et);
		ship.setEngine(e);
		ship.setOrbitalModule(o);
		
		return ship;
	}
	
}
