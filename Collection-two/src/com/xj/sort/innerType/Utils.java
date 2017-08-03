package com.xj.sort.innerType;

import java.util.Comparator;
import java.util.List;

public class Utils {
	
	public static <T extends Comparable<T>> void sort(List<T> list,Comparator<T> com){
		Object[] arr=list.toArray();
		sort(arr,com);
		for(int i=0;i<arr.length;i++){
			list.set(i, (T)arr[i]);
		}
	}
	
	public static <T> void sort(Object[] arr,Comparator<T> com){
		int len=arr.length;
		boolean ordered=true;
		for(int i=0;i<len-1;i++){
			ordered=true;
			for(int j=0;j<len-1-i;j++){
				if(com.compare((T)arr[j], (T)arr[j+1])>0){
					Object temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					ordered=false;
				}
			}
			if(ordered){
				break;
			}
		}
	}
	
	public static <T extends Comparable<T>> void sort(T[] arr){
		int len=arr.length;
		boolean ordered=true;
		for(int i=0;i<len-1;i++){
			ordered=true;
			for(int j=0;j<len-1-i;j++){
				if(((Comparable<T>)arr[j]).compareTo(arr[j+1])>0){
					T temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					ordered=false;
				}
			}
			if(ordered){
				break;
			}
		}
	}
	
	public static void sort(Object[] arr){
		int len=arr.length;
		boolean ordered=true;
		for(int i=0;i<len-1;i++){
			ordered=true;
			for(int j=0;j<len-1-i;j++){
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0){
					Object temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					ordered=false;
				}
			}
			if(ordered){
				break;
			}
		}
	}
	

	
	public static <T extends Comparable<T>> void sort(List<T> list){
		Object[] arr=list.toArray();
		sort(arr);
		for(int i=0;i<arr.length;i++){
			list.set(i, (T)arr[i]);
		}
	}

}
