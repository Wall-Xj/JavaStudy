package com.xj.prototype;

import java.util.Date;

public class Sheep02 implements Cloneable {
	private String name;
	private Date birthday;
		
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj=super.clone();
		Sheep02 s=(Sheep02)obj;
		s.birthday=(Date)this.birthday.clone();
		return obj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Sheep02() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sheep02(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
}
