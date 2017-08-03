package com.xj.others.commons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * Queue队列
 * 1、循环队列
 * 2、只读队列
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
	 * 断言队列
	 */
	public static void predicate(){
		//断言队列
		CircularFifoQueue<String>que=new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNull=NotNullPredicate.INSTANCE;
		//包装成对应的队列
		Queue<String>que2=PredicatedQueue.predicatedQueue(que,notNull);
		que2.add(null);
	}
	/**
	 * 只读队列
	 */
	public static void readOnly(){
		//只读队列
		CircularFifoQueue<String>que=new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Queue<String>readOnlyQue=UnmodifiableQueue.unmodifiableQueue(que);
		//java.lang.UnsupportedOperationException
		readOnlyQue.add("d");
	}
	/**
	 * 循环队列
	 */
	public static void circular(){
		//循环队列
		CircularFifoQueue<String>que=new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		for(int i=0;i<que.size();i++){
			System.out.println(que.get(i));
		}
	}
}
