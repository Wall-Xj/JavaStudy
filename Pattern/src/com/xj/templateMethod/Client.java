package com.xj.templateMethod;
/**
 * ģ�淽��ģ��
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
				System.out.println("��Ǯ");
			}
		};
		btm2.process();
		
		BanfkTemplateMethod btm3=new BanfkTemplateMethod() {
			
			@Override
			public void transact() {
				System.out.println("���");
			}
		};
		btm3.process();
		
	}
}


class DrawMoney extends BanfkTemplateMethod{

	@Override
	public void transact() {
		System.out.println("ȡǮ");
		
	}
	
}