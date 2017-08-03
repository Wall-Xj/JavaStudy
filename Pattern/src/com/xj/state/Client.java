package com.xj.state;

import java.awt.print.Book;
/**
 * ״̬ģʽ
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		Context ctx = new Context();
		ctx.setState(new FreeState());
		ctx.setState(new BookedState());
		ctx.setState(new CheckedState());
	}
}
