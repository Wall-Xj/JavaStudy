package com.xj.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	protected List<Observer>list=new ArrayList<Observer>();
	
	public void registerObserver(Observer o){
		list.add(o);
	}
	
	public void removeObserver(Observer o){
		list.remove(o);
	}
	
	public void notifyAllObserver(){
		for (Observer o : list){
			o.update(this);
		}
	}
}
