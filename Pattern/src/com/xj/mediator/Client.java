package com.xj.mediator;

/**
 * 中介者模式
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		Mediator m=new President();
		
		Market market=new Market(m);
		Development d=new Development(m);
		Finacial f=new Finacial(m);
		
		market.selfAction();
		market.outAction();
				
	}
}
