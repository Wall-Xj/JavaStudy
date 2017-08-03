package com.xj.templateMethod;
/**
 * 模版方法模版
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		BanfkTemplateMethod btm=new DrawMoney();
		btm.process();
		
		BanfkTemplateMethod btm2=new BanfkTemplateMethod() {
			
			@Override
			public void transact() {
				System.out.println("存钱");
			}
		};
		btm2.process();
		
		BanfkTemplateMethod btm3=new BanfkTemplateMethod() {
			
			@Override
			public void transact() {
				System.out.println("理财");
			}
		};
		btm3.process();
		
	}
}


class DrawMoney extends BanfkTemplateMethod{

	@Override
	public void transact() {
		System.out.println("取钱");
		
	}
	
}