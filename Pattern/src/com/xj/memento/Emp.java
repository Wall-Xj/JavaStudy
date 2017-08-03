package com.xj.memento;

import org.omg.Messaging.SyncScopeHelper;

public class Emp {
	private String ename;
	private int age;
	private double salary;

	public EmpMemento memento() {
		return new EmpMemento(this);
	}

	public void recovery(EmpMemento em) {
		this.ename = em.getEname();
		this.age = em.getAge();
		this.salary = em.getSalary();
	}

	public Emp(String ename, int age, double salary) {
		super();
		this.ename = ename;
		this.age = age;
		this.salary = salary;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return this.ename+"--"+age+"---"+salary;
	}
}
