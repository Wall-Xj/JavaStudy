package com.xiejun.io.others;

public class Emloyee implements java.io.Serializable {
	private transient String name;//不需要序列化
	private double salary;
	public Emloyee() {
	}
	public Emloyee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
