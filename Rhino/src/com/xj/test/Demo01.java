package com.xj.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo01 {
	public static void main(String[] args) throws ScriptException {
		//获得脚本引擎对象
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
		//定义对象，存储到引擎上下文
		engine.put("msg", "xiejun is a good man");
		String str="var user={name:'xiejun',age:18,schools:['学校一','学校二']};";
		str+="println(user.name);";
		//执行脚本
		engine.eval(str);
	}
}
