package com.xj.bridge;
/**
 * �Ž�ģʽ
 * @author WanYin
 *
 */
public class Clinet {
	public static void main(String[] args) {
		Brand lenovo=new Lenovo();
		Computer computer=new desktop(lenovo);
		computer.sale();
		
		computer=new Laptop(new Dell());
		computer.sale();
	}
}
