package com.xj.sorm.core;

/**
 * ����Query����Ĺ���
 * 
 * @author WanYin
 *
 */
public class QueryFactory {
	private static Query prototypeObj;	//ԭ�Ͷ���
	static {
		try {
			Class c = Class.forName(DBManager.getConf().getQueryClass());	//����ָ����Query��
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
