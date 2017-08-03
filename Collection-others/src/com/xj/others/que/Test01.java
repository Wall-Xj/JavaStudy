package com.xj.others.que;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test01 {
	public static void main(String[] args) {
		Queue<Request>que=new ArrayDeque<Request>();
		for(int i=0;i<5;i++){
			final int num=i;
			que.offer(new Request(){
				@Override
				public void deposit() {
					System.out.println("�ڣ�"+num+"���˰������"+(Math.random()*10000)+"Ԫ��");
				}
				
			});
		}
		dealWith(que);
	}
	
	private static void dealWith(Queue<Request> que){
		Request req=null;
		while(null!=(req=que.poll())){
			req.deposit();
		}
	}
}

interface Request{
	void deposit();
}
