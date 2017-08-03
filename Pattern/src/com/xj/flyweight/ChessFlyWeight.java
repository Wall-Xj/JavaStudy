package com.xj.flyweight;
/**
 * ��Ԫ��
 * @author WanYin
 *
 */
public interface ChessFlyWeight {
	void setColor(String c);
	String getColor();
	void display(Coordinate c);
}


/**
 * ������Ԫ��
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
		System.out.println("������ɫ��"+color);
		System.out.println("������ɫ��"+c.getX()+"-"+c.getY());
	}
	
}