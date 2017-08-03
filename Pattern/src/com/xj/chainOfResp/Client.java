package com.xj.chainOfResp;

/**
 * 责任链模式
 * 
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		Leader a = new Director("zhang");
		Leader b = new Manager("zhang");
		Leader c = new GeneralManager("zhang");

		a.setNextLeader(b);
		b.setNextLeader(c);

		a.handleRequest(new LeaveRequest("", 32, ""));
	}
}
