package com.xj.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Ŀ�꣺�����������ԭ��--��һ���������Դ����������������
 * ;���� ʹ�����ڲ���|�����ڲ���
 * ����
 * 1��ʹ���ڲ���  ʵ�ֵ�����
 * 2��ʹ��Iterable ʵ��foreach����
 * 
 */
public class DeepList<E> implements java.lang.Iterable<E> {
	//���� �洢ֵ
	private Object[] elem=new Object[5];
	//��С
	private int size=0;
	
	public int size(){
		return this.size;
	}
	
	public void add(E ele){
		if(this.size==elem.length){
			elem=Arrays.copyOf(elem, elem.length+5);
		}
		elem[size]=ele;//�����м���Ԫ��
		size++;
	}
		
	public Iterator<E> iterator(){
		return new Iterator<E>(){//����Iterator�������ӿ� ʵ���ࣨ�����ࣩ��
			//������ --��ָ��  �α�
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
				// �ƶ�����Ԫ��
				System.arraycopy(elem, coursor+1, elem, coursor, DeepList.this.size-(coursor+1));
				//ʵ�ʴ�С-1
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
