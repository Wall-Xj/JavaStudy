package com.xj.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo01 {
	public static void main(String[] args) throws ScriptException {
		//��ýű��������
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
		//������󣬴洢������������
		engine.put("msg", "xiejun is a good man");
		String str="var user={name:'xiejun',age:18,schools:['ѧУһ','ѧУ��']};";
		str+="println(user.name);";
		//ִ�нű�
		engine.eval(str);
	}
}
