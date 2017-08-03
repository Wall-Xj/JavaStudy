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
 * ����ʽ���Closure �հ� ��װ�ض���ҵ����
 * 1��Closure
 * 2��IfClosure  IfClosure.ifClosure(����, ����1,����2);
 * 3��WhileClosure WhileClosure.whileClosure�����ԣ����ܣ���ִ�еĵı�ʶ��
 * 4��ChainedClosure ChainedClosure.chainedClosure(�������б�);
 * 
 * 	CollectionUtils.forAllDo(���������������)
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
	 * ���ϼ�	�ȴ�����Ʒ������9�ۣ������ټ�20
	 */
	public static void chainedClosure(){
		List<Goods>goodsList=new ArrayList<Goods>();
		goodsList.add(new Goods("javase��Ƶ",120,true));
		goodsList.add(new Goods("javaee��Ƶ",100,false));
		goodsList.add(new Goods("���¼���",80,false));
		
		//���ټ�20
		Closure<Goods>subtract=new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.getPrice()>=100){
					input.setPrice(input.getPrice()-20);
				}
			}
			
		};
		//����
		Closure<Goods>discount=new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.isDiscount()){
					input.setPrice(input.getPrice()*0.9);
				}
			}
			
		};

		//��ѡһ
		Closure<Goods>chainClo=ChainedClosure.chainedClosure(discount,subtract);
		//����
		CollectionUtils.forAllDo(goodsList,chainClo);
		//�鿴�����������
		for(Goods temp:goodsList){
			System.out.println(temp.toString());
		}
	}
	/**
	 * ȷ������Ա�����ʶ�����10000������Ѿ������Ĳ�������
	 */
	public static void whileClosure(){
		//����
		List<Employee>empList=new ArrayList<Employee>();
		empList.add(new Employee("shanghai",40000));
		empList.add(new Employee("beijin",30000));
		empList.add(new Employee("hangzhou",5000));
		//ҵ����
		Closure<Employee>cols=new Closure<Employee>(){
			@Override 
			public void execute(Employee input) {
				input.setSalary(input.getSalary()*1.2);
			}
		};
		//�ж�
		Predicate<Employee>empPre=new Predicate<Employee>(){

			@Override
			public boolean evaluate(Employee object) {
				
				return object.getSalary()<10000;
			}
			
		};
		//false ��ʾwhile�ṹ ���ж���ִ��  true do..while ��ִ�к��ж�
		Closure<Employee>whileClos=WhileClosure.whileClosure(empPre, cols, false);
		
		//������
		CollectionUtils.forAllDo(empList, whileClos);
		
		//�����������
		Iterator<Employee>empIt=empList.iterator();
		while(empIt.hasNext()){
			System.out.println(empIt.next());
		}
	}
	
	/**
	 * ��ѡһ ����Ǵ�����Ʒ������9�ۣ��������ټ�20
	 */
	public static void ifClosure(){
		List<Goods>goodsList=new ArrayList<Goods>();
		goodsList.add(new Goods("javase��Ƶ",120,true));
		goodsList.add(new Goods("javaee��Ƶ",100,false));
		goodsList.add(new Goods("���¼���",80,false));
		
		//���ټ�20
		Closure<Goods>subtract=new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.getPrice()>=100){
					input.setPrice(input.getPrice()-20);
				}
			}
			
		};
		//����
		Closure<Goods>discount=new Closure<Goods>(){

			@Override
			public void execute(Goods input) {
				if(input.isDiscount()){
					input.setPrice(input.getPrice()*0.9);
				}
			}
			
		};
		//�ж�
		Predicate<Goods>pre=new Predicate<Goods>(){

			@Override
			public boolean evaluate(Goods object) {
				return object.isDiscount();
			}
			
		};
		//��ѡһ
		Closure<Goods>ifClo=IfClosure.ifClosure(pre, discount,subtract);
		CollectionUtils.forAllDo(goodsList,ifClo);
		//�鿴�����������
		for(Goods temp:goodsList){
			System.out.println(temp.toString());
		}
	}
	
	
	/**
	 * ��������
	 */
	public static void basic(){
		//����
		List<Employee>empList=new ArrayList<Employee>();
		empList.add(new Employee("shanghai",40000));
		empList.add(new Employee("beijin",30000));
		empList.add(new Employee("hangzhou",20000));
		//ҵ����
		Closure<Employee>cols=new Closure<Employee>(){
			@Override 
			public void execute(Employee input) {
				input.setSalary(input.getSalary()*1.2);
			}
		};
		//������
		CollectionUtils.forAllDo(empList, cols);
		
		//�����������
		Iterator<Employee>empIt=empList.iterator();
		while(empIt.hasNext()){
			System.out.println(empIt.next());
		}
		
	}
	
}
