package com.xj.iterator;

import java.util.Arrays;

/**
 * Ŀ�꣺����������ԭ��
 * 
 * @author Administrator
 *
 */
public class SimpleLsit {
	public static void main(String[] args) {
		// ��ʼ��  
	    int[] ids = { 1, 2, 3, 4, 5 };  
	    System.out.println(Arrays.toString(ids)); // [1, 2, 3, 4, 5]  
	    System.arraycopy(ids,2, ids, 1, 3);  
	    System.out.println(Arrays.toString(ids));
	 // �������Ҹ���  
	    // �Ѵ�����0��ʼ��2�����ָ��Ƶ�����Ϊ3��λ����  
	    System.arraycopy(ids, 0, ids, 3, 2);  
	    System.out.println(Arrays.toString(ids)); // [1, 2, 3, 1, 2]  
	    // ���Ը��Ƶ����������  
	    // �����ݵ�����1��ʼ��3�����ݸ��Ƶ�Ŀ�������Ϊ0��λ����  
	    int[] ids2 = new int[6];  
	    System.arraycopy(ids, 1, ids2, 0, 3);  
	    System.out.println(Arrays.toString(ids2)); // [2, 3, 1, 0, 0, 0] 
	    
	}
	
}
