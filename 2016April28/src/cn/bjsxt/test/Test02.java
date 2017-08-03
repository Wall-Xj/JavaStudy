package cn.bjsxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
		Date date=new Date();
		date.setTime(1253496445L);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String d1=df.format(date);
		System.out.println(d1);
		Date date1=new Date(1253496445L);
		String d2=df.format(date1);
		System.out.println(d2);
		System.out.println(date.before(date1));
		System.out.println(date.after(date1));
		System.out.println(date.equals(date1));
		System.out.println(date.compareTo(date1));
		System.out.println(date.toString());
		
		DateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
		String d3="1970-4-4";
		try {
			Date date2=df2.parse(d3);
			System.out.println(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
