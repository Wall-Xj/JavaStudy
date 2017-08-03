package com.xj.others.three;

import java.util.EnumMap;
import java.util.Map;

/**
 * EnumMap Ҫ���λö��
 * @author Administrator
 *
 */
public class EnumMapTest {
	public static void main(String[] args) {
		EnumMap<Season,String>map=new EnumMap<Season,String>(Season.class);
		map.put(Season.SPRING, "����");
		map.put(Season.SUMMER, "����");
		map.put(Season.AUTUMN, "����");
		map.put(Season.WINTER, "����");
		for (Map.Entry<Season, String> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: "
					+ entry.getValue());
		}
	}
}

//����
enum Season{
	SPRING,SUMMER,AUTUMN,WINTER
}