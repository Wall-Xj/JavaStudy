package com.xj.flyweight;

public class Client {
	public static void main(String[] args) {
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑");
		System.out.println(chess1.getColor());
		System.out.println(chess2.getColor());

		System.out.println("增加外部状态操作：");
		chess1.display(new Coordinate(1, 2));
		chess2.display(new Coordinate(2, 2));
	}
}
