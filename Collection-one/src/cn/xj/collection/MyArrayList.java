package cn.xj.collection;

import java.util.Arrays;

public class MyArrayList {
	private Object[] elementData;
	
	private int size;
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int initialCapacity){
		if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        this.elementData = new Object[initialCapacity];
	}
	
	public void add(Object e){
		if(size>=elementData.length){
//			Object[] newArray=new Object[size*2+1];
			this.elementData=Arrays.copyOf(elementData, size*2+1);
		}
		elementData[size++] = e;
	}
	
	public Object get(int index){
		
		return elementData[index];
	}
	
	
	public static void main(String[] args) {
		MyArrayList list=new MyArrayList(5);
		list.add("sd");
		list.add("sd");
		list.add(11);
		list.add("sd");
		list.add("sd");
		
		for(int i=0;i<list.size;i++){
			System.out.println(list.get(i));
		}
	}
}
