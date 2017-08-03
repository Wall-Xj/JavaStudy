package com.xj.others.guava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;
/**
 * ˫����Map==>Table==>roeKey+ColumnKey+value
 * 1������
 * 	���������ݣ�cellSet()
 * 	����ѧ����rowKeySet()
 * 	���пγ̣�columnKeySet()
 * 	���гɼ���values()
 * 	ѧ����Ӧ�γ̣�rowMap()+get(ѧ����
 * 				row(ѧ��)
 * 	ѧ����Ӧ�γ̣�columnMap()+get(�γ̣�
 * 				column(�γ�)
 * @author Administrator
 *
 */
public class Test08 {
	public static void main(String[] args) {
		Table<String,String,Integer>tables=HashBasedTable.create();
		//��������
		tables.put("a", "javase", 80);
		tables.put("b", "javase", 90);
		tables.put("a", "oracle", 100);
		tables.put("d", "oracle", 98);
		//���е�������
		Set<Cell<String,String,Integer>>cells=tables.cellSet();
		for(Cell<String,String,Integer> temp:cells){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
		System.out.println("==========��ѧ���鿴�ɼ�============");
		System.out.print("ѧ��\t");
		//���пγ�
		Set<String>cours=tables.columnKeySet();
		for(String t:cours){
			System.out.print(t+"\t");
		}
		System.out.println();
		//����ѧ��
		Set<String>stus=tables.rowKeySet();
		for(String t:stus){
			System.out.print(t+"\t");
			Map<String,Integer>scores=tables.row(t);
			for(String c:cours){
				System.out.print(scores.get(c)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("==========���γ̲鿴�ɼ�============");
		System.out.print("�γ�\t");
		//����ѧ��
		cours=tables.rowKeySet();
		for(String t:cours){
			System.out.print(t+"\t");
		}
		System.out.println();
		//���пγ�
		stus=tables.columnKeySet();
		for(String t:stus){
			System.out.print(t+"\t");
			Map<String,Integer>scores=tables.column(t);
			for(String c:cours){
				System.out.print(scores.get(c)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("===============ת��===============");
		Table<String,String,Integer>tables2=Tables.transpose(tables);
		//���е�������
		Set<Cell<String,String,Integer>>cells2=tables2.cellSet();
		for(Cell<String,String,Integer> temp:cells2){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
	}
}
