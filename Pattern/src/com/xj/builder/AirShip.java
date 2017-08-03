package com.xj.builder;

public class AirShip {
	private OrbitalModule orbitalModule;//�����
	private Engine engine;//������
	private EscapeTower escapeTower;//������
	public OrbitalModule getOrbitalModule() {
		return orbitalModule;
	}
	public void setOrbitalModule(OrbitalModule orbitalModule) {
		this.orbitalModule = orbitalModule;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public EscapeTower getEacapeTower() {
		return escapeTower;
	}
	public void setEacapeTower(EscapeTower eacapeTower) {
		this.escapeTower = eacapeTower;
	}
	
	public void launch(){
		System.out.println("���䣡");
	}

}

class OrbitalModule{
	
	private String name;
	
	public OrbitalModule(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Engine{
	
	private String name;

	public Engine(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}


class EscapeTower{
	
	private String name;

	public EscapeTower(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
