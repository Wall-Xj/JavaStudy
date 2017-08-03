package com.xj.others.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

/**
 * 函数式编程Closure 闭包 封装特定的业务功能
 * 1、Closure
 * 2、IfClosure  IfClosure.ifClosure(断言, 功能1,功能2);
 * 3、WhileClosure WhileClosure.whileClosure（断言，功能，先执行的的标识）
 * 4、ChainedClosure ChainedClosure.chainedClosure(处理功能列表);
 * 
 * 	CollectionUtils.forAllDo(容器，功能类对象)
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) {
		//basic();
		//ifClosure();
		//whileClosure();
		chainedClosure();
	}
	/**
	 * 折上减	先打折商品，进行9折，满百再减20
	 */
	public static void chainedClosure(){
		List<Goods>goodsList=new ArrayList<Goods>();
		goodsList.add(new Goods("javase视频",120,true));
		goodsList.add(new Goods("javaee视频",100,false));
		goodsList.add(new Goods("高新技术",80,false));
		
		//满百减20
		Closure<Goods>subtract=new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.getPrice()>=100){
					input.setPrice(input.getPrice()-20);
				}
			}
			
		};
		//打折
		Closure<Goods>discount=new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.isDiscount()){
					input.setPrice(input.getPrice()*0.9);
				}
			}
			
		};

		//二选一
		Closure<Goods>chainClo=ChainedClosure.chainedClosure(discount,subtract);
		//关联
		CollectionUtils.forAllDo(goodsList,chainClo);
		//查看操作后的数据
		for(Goods temp:goodsList){
			System.out.println(temp.toString());
		}
	}
	/**
	 * 确保所有员工工资都大于10000，如果已经超过的不再上涨
	 */
	public static void whileClosure(){
		//数据
		List<Employee>empList=new ArrayList<Employee>();
		empList.add(new Employee("shanghai",40000));
		empList.add(new Employee("beijin",30000));
		empList.add(new Employee("hangzhou",5000));
		//业务公能
		Closure<Employee>cols=new Closure<Employee>(){
			@Override 
			public void execute(Employee input) {
				input.setSalary(input.getSalary()*1.2);
			}
		};
		//判断
		Predicate<Employee>empPre=new Predicate<Employee>(){

			@Override
			public boolean evaluate(Employee object) {
				
				return object.getSalary()<10000;
			}
			
		};
		//false 表示while结构 先判断再执行  true do..while 先执行后判断
		Closure<Employee>whileClos=WhileClosure.whileClosure(empPre, cols, false);
		
		//工具类
		CollectionUtils.forAllDo(empList, whileClos);
		
		//操作后的数据
		Iterator<Employee>empIt=empList.iterator();
		while(empIt.hasNext()){
			System.out.println(empIt.next());
		}
	}
	
	/**
	 * 二选一 如果是打折商品，进行9折，否则满百减20
	 */
	public static void ifClosure(){
		List<Goods>goodsList=new ArrayList<Goods>();
		goodsList.add(new Goods("javase视频",120,true));
		goodsList.add(new Goods("javaee视频",100,false));
		goodsList.add(new Goods("高新技术",80,false));
		
		//满百减20
		Closure<Goods>subtract=new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.getPrice()>=100){
					input.setPrice(input.getPrice()-20);
				}
			}
			
		};
		//打折
		Closure<Goods>discount=new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.isDiscount()){
					input.setPrice(input.getPrice()*0.9);
				}
			}
			
		};
		//判断
		Predicate<Goods>pre=new Predicate<Goods>(){

			@Override
			public boolean evaluate(Goods object) {
				return object.isDiscount();
			}
			
		};
		//二选一
		Closure<Goods>ifClo=IfClosure.ifClosure(pre, discount,subtract);
		CollectionUtils.forAllDo(goodsList,ifClo);
		//查看操作后的数据
		for(Goods temp:goodsList){
			System.out.println(temp.toString());
		}
	}
	
	
	/**
	 * 基本操作
	 */
	public static void basic(){
		//数据
		List<Employee>empList=new ArrayList<Employee>();
		empList.add(new Employee("shanghai",40000));
		empList.add(new Employee("beijin",30000));
		empList.add(new Employee("hangzhou",20000));
		//业务公能
		Closure<Employee>cols=new Closure<Employee>(){
			@Override 
			public void execute(Employee input) {
				input.setSalary(input.getSalary()*1.2);
			}
		};
		//工具类
		CollectionUtils.forAllDo(empList, cols);
		
		//操作后的数据
		Iterator<Employee>empIt=empList.iterator();
		while(empIt.hasNext()){
			System.out.println(empIt.next());
		}
		
	}
	
}
