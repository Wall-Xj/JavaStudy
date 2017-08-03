package cn.bjsxt.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test03 {
	public static void main(String[] args) {
		Calendar c=new GregorianCalendar();
		c.set(2001,1,10,12,23,34);
//		c.set(Calendar.YEAR,2001);
//		c.set(Calendar.MONTH,2);
//		c.set(Calendar.DAY_OF_MONTH, 1);
//		c.setTime(new Date());
		Date d=c.getTime();
		System.out.println(d);
		System.out.println(c.get(Calendar.YEAR));
		c.add(Calendar.YEAR, 1);
		System.out.println(c.getTimeInMillis());
		Date d1=new Date(1013315014851L);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(df.format(d1));
	}
}
