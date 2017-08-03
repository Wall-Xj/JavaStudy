package com.xj.po;

import java.sql.*;
import java.util.*;

public class Emp {

	private java.sql.Date birthday;
	private Integer gender;
	private Double bonus;
	private String name;
	private Integer id;
	private Integer department;
	private Double salary;


	public java.sql.Date getBirthday(){
		return birthday;
	}
	public Integer getGender(){
		return gender;
	}
	public Double getBonus(){
		return bonus;
	}
	public String getName(){
		return name;
	}
	public Integer getId(){
		return id;
	}
	public Integer getDepartment(){
		return department;
	}
	public Double getSalary(){
		return salary;
	}
	public void setBirthday(java.sql.Date birthday){
		this.birthday=birthday;
	}
	public void setGender(Integer gender){
		this.gender=gender;
	}
	public void setBonus(Double bonus){
		this.bonus=bonus;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setDepartment(Integer department){
		this.department=department;
	}
	public void setSalary(Double salary){
		this.salary=salary;
	}
}
