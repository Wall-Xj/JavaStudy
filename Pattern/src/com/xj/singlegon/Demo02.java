package com.xj.singlegon;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Demo02 implements Serializable {
	//ÀÁººÄ£Ê½
	private static Demo02 demo;
	
	private Demo02(){
		
	}
	
	public static synchronized Demo02 getInstance(){
		if(demo==null){
			demo=new Demo02();
		}
		return demo;
	}
	
	private Object readResolve() throws ObjectStreamException {
		return demo;
	}
}

