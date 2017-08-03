package com.xj.observer2;

import java.util.Observable;
import java.util.Observer;

import com.xj.observer.Subject;

public class ObserverA implements Observer {

	private int myState;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		myState=((ConcreteSubject)arg0).getState();
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}
	

	
}
