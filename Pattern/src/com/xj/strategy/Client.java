package com.xj.strategy;

/**
 * ²ßÂÔÄ£Ê½
 * 
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		Strategy strategy = new OldCustomerFewStrategy();
		Context ctx = new Context(strategy);
		ctx.pringPerice(300);
	}
}
