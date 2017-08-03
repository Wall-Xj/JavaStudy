package com.xj.po;

import java.sql.*;
import java.util.*;

public class T_users {

	private String realName;
	private String userPwd;
	private Integer Id;
	private String userName;
	private java.sql.Date register;


	public String getRealName(){
		return realName;
	}
	public String getUserPwd(){
		return userPwd;
	}
	public Integer getId(){
		return Id;
	}
	public String getUserName(){
		return userName;
	}
	public java.sql.Date getRegister(){
		return register;
	}
	public void setRealName(String realName){
		this.realName=realName;
	}
	public void setUserPwd(String userPwd){
		this.userPwd=userPwd;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setRegister(java.sql.Date register){
		this.register=register;
	}
}
