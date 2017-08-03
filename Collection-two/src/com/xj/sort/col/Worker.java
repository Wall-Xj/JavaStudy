package com.xj.sort.col;

public class Worker implements java.lang.Comparable<Worker> {
	private String name;
	private int salary;
	
	public Worker() {
		super();
	}
	public Worker(String name, int salary) {
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return this.name+":"+this.salary+"\n";
	}
	@Override
	public int compareTo(Worker o) {
		return this.salary>o.salary?1:(this.salary==o.salary?0:-1);
	}
}
