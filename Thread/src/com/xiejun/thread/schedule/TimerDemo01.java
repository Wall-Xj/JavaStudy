package com.xiejun.thread.schedule;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度
 * Timer()
 * schedule(TimerTask task,Date time)
 * schedule(TimerTask task,Date firstTime,long period)
 * @author Administrator
 *
 */
public class TimerDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("hellow world....");
				
			}}, 2000,200);

	}

}
