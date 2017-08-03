package cn.xj.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("a",new wife("A"));
		map.put("b",new wife("B"));
		map.put("a",new wife("aB"));
		wife w=(wife)map.get("a");
		System.out.println(w.getName());
		
	}
}

class wife{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public wife(String name) {
		super();
		this.name = name;
	}
	
}
