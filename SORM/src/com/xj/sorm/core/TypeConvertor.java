package com.xj.sorm.core;
/**
 * java���ͺ����ݿ����ͻ���ת��
 * @author WanYin
 *
 */
public interface TypeConvertor {
	
	public String databaseType2JavaType(String columnType);
	
	public String javaType2DatabaseType(String javaDataType);
}
