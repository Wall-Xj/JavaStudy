package com.xj.sorm.core;

/**
 * 创建Query对象的工厂
 * 
 * @author WanYin
 *
 */
public class QueryFactory {
	private static Query prototypeObj;	//原型对象
	static {
		try {
			Class c = Class.forName(DBManager.getConf().getQueryClass());	//加载指定的Query类
			prototypeObj = (Query) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	 public static Query createQuery(){
		 try {
			return (Query)prototypeObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	 }
}
