package com.xj.strategy;

/**
 * ����ģʽ
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
