package com.xj.iterator;

import java.util.Arrays;

/**
 * 目标：理解迭代器的原理
 * 
 * @author Administrator
 *
 */
public class SimpleLsit {
	public static void main(String[] args) {
		// 初始化  
	    int[] ids = { 1, 2, 3, 4, 5 };  
	    System.out.println(Arrays.toString(ids)); // [1, 2, 3, 4, 5]  
	    System.arraycopy(ids,2, ids, 1, 3);  
	    System.out.println(Arrays.toString(ids));
	 // 测试自我复制  
	    // 把从索引0开始的2个数字复制到索引为3的位置上  
	    System.arraycopy(ids, 0, ids, 3, 2);  
	    System.out.println(Arrays.toString(ids)); // [1, 2, 3, 1, 2]  
	    // 测试复制到别的数组上  
	    // 将数据的索引1开始的3个数据复制到目标的索引为0的位置上  
	    int[] ids2 = new int[6];  
	    System.arraycopy(ids, 1, ids2, 0, 3);  
	    System.out.println(Arrays.toString(ids2)); // [2, 3, 1, 0, 0, 0] 
	    
	}
	
}
