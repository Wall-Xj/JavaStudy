package com.xj.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 目标：深入迭代器的原理--》一个容器可以创建多个迭代器对象
 * 途径： 使用了内部类|匿名内部类
 * 深入
 * 1、使用内部类  实现迭代器
 * 2、使用Iterable 实现foreach迭代
 * 
 */
public class DeepList<E> implements java.lang.Iterable<E> {
	//数组 存储值
	private Object[] elem=new Object[5];
	//大小
	private int size=0;
	
	public int size(){
		return this.size;
	}
	
	public void add(E ele){
		if(this.size==elem.length){
			elem=Arrays.copyOf(elem, elem.length+5);
		}
		elem[size]=ele;//数组中加入元素
		size++;
	}
		
	public Iterator<E> iterator(){
		return new Iterator<E>(){//创建Iterator迭代器接口 实现类（匿名类）的
			//计数器 --》指针  游标
			private int coursor=-1;
			
			@Override
			public boolean hasNext() {
				return coursor+1<size;
			}

			@Override
			public E next() {
				coursor++;
				return (E)elem[coursor];
			}

			@Override
			public void remove() {
				// 移动数组元素
				System.arraycopy(elem, coursor+1, elem, coursor, DeepList.this.size-(coursor+1));
				//实际大小-1
				DeepList.this.size--;
				this.coursor--;
			}
		};
	}
	
	public static void main(String[] args) {
		DeepList<String> list=new DeepList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		for(Iterator<String> iter=list.iterator();iter.hasNext();){
			System.out.println(iter.next());
		}
		
		DeepList<Integer> list1=new DeepList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		for(Integer e:list1){
			System.out.println(e);
		}
		
	}
	
}
