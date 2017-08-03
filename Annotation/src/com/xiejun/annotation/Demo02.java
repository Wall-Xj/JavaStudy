package com.xiejun.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * @author Administrator
 *
 */

public class Demo02 {
	public static void main(String[] args) {
		Class clazz;
		try {
			clazz = Class.forName("com.xiejun.annotation.SxtStudent");
						
			//获得类的所有有效注解
			Annotation[] annotations=clazz.getAnnotations();
			for(Annotation a : annotations){
				System.out.println(a);
			}
			//获得类的指定注解
			SxtTable st=(SxtTable)clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			//获得类属性的注解
			Field f=clazz.getDeclaredField("studentName");
			SxtField sxtField=f.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.length());
			//根据获得的表名，字段信息，拼出DDL语句，然后使用JDBC执行这个SQL,在数据库中生成相关的表
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
