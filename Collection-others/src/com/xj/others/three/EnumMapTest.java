package com.xj.others.three;

import java.util.EnumMap;
import java.util.Map;

/**
 * EnumMap 要求键位枚举
 * @author Administrator
 *
 */
public class EnumMapTest {
	public static void main(String[] args) {
		EnumMap<Season,String>map=new EnumMap<Season,String>(Season.class);
		map.put(Season.SPRING, "春天");
		map.put(Season.SUMMER, "夏天");
		map.put(Season.AUTUMN, "秋天");
		map.put(Season.WINTER, "冬天");
		for (Map.Entry<Season, String> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: "
					+ entry.getValue());
		}
	}
}

//季节
enum Season{
	SPRING,SUMMER,AUTUMN,WINTER
}