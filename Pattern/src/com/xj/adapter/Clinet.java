package com.xj.adapter;
/**
 * ÊÊÅäÆ÷Ä£Ê½
 * @author WanYin
 *
 */
public class Clinet {
	
	public void test(Target t){
		t.handleReq();
	}
	
	public static void main(String[] args) {
		Adaptee a=new Adaptee();
		
//		Target t=new Adapter();
		
		Target t=new Adapter2(a);
		
		
		Clinet c=new Clinet();
		c.test(t);
	}
	

}
