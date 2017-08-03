package com.xj.jdbcTest;

public class CloseUtil {
	public static <T extends AutoCloseable> void closeJdbc(T... ts){
		for(AutoCloseable t : ts){
			try {
				if(t!=null){
					t.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
