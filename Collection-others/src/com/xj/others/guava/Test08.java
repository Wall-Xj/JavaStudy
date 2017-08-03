package com.xj.others.guava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;
/**
 * 双键的Map==>Table==>roeKey+ColumnKey+value
 * 1、方法
 * 	所有行数据：cellSet()
 * 	所有学生：rowKeySet()
 * 	所有课程：columnKeySet()
 * 	所有成绩：values()
 * 	学生对应课程：rowMap()+get(学生）
 * 				row(学生)
 * 	学生对应课程：columnMap()+get(课程）
 * 				column(课程)
 * @author Administrator
 *
 */
public class Test08 {
	public static void main(String[] args) {
		Table<String,String,Integer>tables=HashBasedTable.create();
		//测试数据
		tables.put("a", "javase", 80);
		tables.put("b", "javase", 90);
		tables.put("a", "oracle", 100);
		tables.put("d", "oracle", 98);
		//所有的行数据
		Set<Cell<String,String,Integer>>cells=tables.cellSet();
		for(Cell<String,String,Integer> temp:cells){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
		System.out.println("==========按学生查看成绩============");
		System.out.print("学生\t");
		//所有课程
		Set<String>cours=tables.columnKeySet();
		for(String t:cours){
			System.out.print(t+"\t");
		}
		System.out.println();
		//所有学生
		Set<String>stus=tables.rowKeySet();
		for(String t:stus){
			System.out.print(t+"\t");
			Map<String,Integer>scores=tables.row(t);
			for(String c:cours){
				System.out.print(scores.get(c)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("==========按课程查看成绩============");
		System.out.print("课程\t");
		//所有学生
		cours=tables.rowKeySet();
		for(String t:cours){
			System.out.print(t+"\t");
		}
		System.out.println();
		//所有课程
		stus=tables.columnKeySet();
		for(String t:stus){
			System.out.print(t+"\t");
			Map<String,Integer>scores=tables.column(t);
			for(String c:cours){
				System.out.print(scores.get(c)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("===============转换===============");
		Table<String,String,Integer>tables2=Tables.transpose(tables);
		//所有的行数据
		Set<Cell<String,String,Integer>>cells2=tables2.cellSet();
		for(Cell<String,String,Integer> temp:cells2){
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
	}
}
