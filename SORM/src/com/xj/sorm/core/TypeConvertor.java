package com.xj.sorm.core;
/**
 * java类型和数据库类型互相转换
 * @author WanYin
 *
 */
public interface TypeConvertor {
	
	public String databaseType2JavaType(String columnType);
	
	public String javaType2DatabaseType(String javaDataType);
}
