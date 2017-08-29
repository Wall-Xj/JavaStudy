package com.xj;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	// Session session = new
	// AnnotationConfiguration().configure().buildSessionFactory().openSession();
	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
			.build();
	 private static SessionFactory sf=null;      
	    private HibernateUtils(){  
	          
	    }  
	    public static SessionFactory getSessionFactory(){  
	        if(sf==null){  
	    		// 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
	        	sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	        }  
	        return sf;  
	    }  
}
