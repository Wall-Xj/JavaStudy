package com.xj.others.commons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * Queue����
 * 1��ѭ������
 * 2��ֻ������
 * @author Administrator
 *
 */
public class Test05 {
	public static void main(String[] args) {
		//circular();
		//readOnly();
		predicate();
	}
	/**
	 * ���Զ���
	 */
	public static void predicate(){
		//���Զ���
		CircularFifoQueue<String>que=new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNull=NotNullPredicate.INSTANCE;
		//��װ�ɶ�Ӧ�Ķ���
		Queue<String>que2=PredicatedQueue.predicatedQueue(que,notNull);
		que2.add(null);
	}
	/**
	 * ֻ������
	 */
	public static void readOnly(){
		//ֻ������
		CircularFifoQueue<String>que=new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Queue<String>readOnlyQue=UnmodifiableQueue.unmodifiableQueue(que);
		//java.lang.UnsupportedOperationException
		readOnlyQue.add("d");
	}
	/**
	 * ѭ������
	 */
	public static void circular(){
		//ѭ������
		CircularFifoQueue<String>que=new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		for(int i=0;i<que.size();i++){
			System.out.println(que.get(i));
		}
	}
}
