package com.xj.Command;

/**
 * ����ģʽ
 * 
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		Command command = new ConcreteCommand(new Receiver());
		Invoke i = new Invoke(command);

		i.call();

		// new Receiver().action();
	}
}
