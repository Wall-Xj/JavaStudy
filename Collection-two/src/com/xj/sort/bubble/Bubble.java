package com.xj.sort.bubble;

import java.util.Arrays;

public class Bubble {
	public static void main(String[] args) {
		int[] arr={2,5,4,6,1};
		sortFinal(arr);
	}
	
	private static void sortFinal(int[] arr){
		boolean sorted=true;
		int len=arr.length;
		for(int i=0;i<len-1;i++){
			sorted=true;
			for(int j=0;j<len-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					sorted=false;
				}
			}
			if(sorted){
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
