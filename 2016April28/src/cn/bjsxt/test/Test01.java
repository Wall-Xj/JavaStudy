package cn.bjsxt.test;

public class Test01 {
	public static void main(String[] args) {
		Integer i=new Integer(1000);
		Integer i2=Integer.parseInt("526");
		System.out.println(Integer.toHexString(i));
		System.out.println(i2);
		Integer i3=new Integer(526);
		System.out.println(i3==i2);
		Integer i4=new Integer(526);
		Integer i5=i4;
		System.out.println(i3==i4);
		int a=1;
		int b=1;
		System.out.println(a==b);
		
	}
}
