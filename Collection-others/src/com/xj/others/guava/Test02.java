package com.xj.others.guava;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 函数是编程 ：解耦
 * 1、Predicate
 * 2、Function
 * 
 * 工具：Collections2.filter()过滤器
 * Collections2.transform()转换
 * Functions.compose() 组合式编程
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//组合式函数编程
		//确保容器中的字符串长度不超过5，超过进行截取，后全部大写
		List<String>list=Lists.newArrayList("goods","happiness","writable","Collections");
		//确保容器中的字符串长度不超过5，超过进行截取
		Function<String,String>f1=new Function<String,String>(){

			@Override
			public String apply(String input) {
				return input.length()>5?input.substring(0,5):input;
			}
			
		};
		//转成大写
		Function<String,String>f2=new Function<String,String>(){

			@Override
			public String apply(String input) {
				return input.toUpperCase();
			}
			
		};
		
		Function<String,String>f=Functions.compose(f1, f2);
		Collection<String>resultCol=Collections2.transform(list, f);
		
		for(String temp:resultCol){
			System.out.println(temp);
		}
		
	}
	
	/**
	 * 过滤器
	 */
	public static void test1(){
		//创建list 静态初始化
		List<String>list=Lists.newArrayList("mom","dad","xi","son");
		//找出回文
		//匿名内部类对象：匿名内部类，同时创建类的对象
		Collection<String>palindromeList=Collections2.filter(list, new Predicate<String>(){

			@Override
			public boolean apply(String input) {
				//业务逻辑
				return new StringBuilder(input).reverse().toString().equals(input);
			}
			
		});
		
		for(String temp:palindromeList){
			System.out.println(temp);
		}
	}
	
	/**
	 * 转换
	 */
	public static void test2(){
		//类型转换
				Set<Long>timeSet=Sets.newHashSet();	
				timeSet.add(1000000000L);
				timeSet.add(999999999999999L);
				timeSet.add(200000000L);
				
				Collection<String>timeStrCol=Collections2.transform(timeSet,new Function<Long,String>(){

					@Override
					public String apply(Long input) {
						return new SimpleDateFormat("yyyy-MM-dd").format(input);
					}
				});
				for(String temp:timeStrCol){
					System.out.println(temp);
				}
	}
	
}
