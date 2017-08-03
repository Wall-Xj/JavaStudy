package com.xj.sort.innerType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test01 {
	public static void main(String[] args) {
		Integer[] a1 = { 1, 2, 6, 5, 8 };
		Utils.sort(a1);
		System.out.println(Arrays.toString(a1));

		String[] a2 = { "asd", "asf", "asdf", "abc", "acd" };
		Utils.sort(a2);
		System.out.println(Arrays.toString(a2));

		Date[] a3 = new Date[3];
		a3[0] = new Date();
		a3[1] = new Date(System.currentTimeMillis() - 1000 * 60 * 60);
		a3[2] = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
		Utils.sort(a3);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		for (Date d : a3) {
			System.out.print(df.format(d) + "\t");
		}

		String str = "2016-5-16";
		try {
			Date d = df.parse(str);
			Calendar cld = new GregorianCalendar();
			cld.setTime(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
