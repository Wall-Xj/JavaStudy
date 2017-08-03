package com.xiejun.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ʹ�÷����ȡע�����Ϣ��ģ�⴦��ע����Ϣ������
 * @author Administrator
 *
 */

public class Demo02 {
	public static void main(String[] args) {
		Class clazz;
		try {
			clazz = Class.forName("com.xiejun.annotation.SxtStudent");
						
			//������������Чע��
			Annotation[] annotations=clazz.getAnnotations();
			for(Annotation a : annotations){
				System.out.println(a);
			}
			//������ָ��ע��
			SxtTable st=(SxtTable)clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			//��������Ե�ע��
			Field f=clazz.getDeclaredField("studentName");
			SxtField sxtField=f.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.length());
			//���ݻ�õı������ֶ���Ϣ��ƴ��DDL��䣬Ȼ��ʹ��JDBCִ�����SQL,�����ݿ���������صı�
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
