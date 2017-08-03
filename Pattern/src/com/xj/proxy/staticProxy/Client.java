package com.xj.proxy.staticProxy;
/**
 * ¾²Ì¬´úÀí
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		RealStar star=new RealStar();
		ProxyStar proxy=new ProxyStar(star);
		
		proxy.confer();
		proxy.singContract();
		proxy.bookTicket();
		proxy.sing();
		proxy.collectMoney();
	}
}
