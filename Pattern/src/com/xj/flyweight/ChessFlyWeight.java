package com.xj.flyweight;
/**
 * 享元类
 * @author WanYin
 *
 */
public interface ChessFlyWeight {
	void setColor(String c);
	String getColor();
	void display(Coordinate c);
}


/**
 * 具体享元类
 * @author WanYin
 *
 */
class ConcreateChess implements ChessFlyWeight{

	private String color;
	
	public ConcreateChess(String color) {
		super();
		this.color = color;
	}

	@Override
	public void setColor(String c) {
		this.color=c;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void display(Coordinate c) {
		System.out.println("棋子颜色："+color);
		System.out.println("棋子颜色："+c.getX()+"-"+c.getY());
	}
	
}