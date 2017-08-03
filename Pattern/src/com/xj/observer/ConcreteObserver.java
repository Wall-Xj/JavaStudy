package com.xj.observer;

public class ConcreteObserver implements Observer {

	private int myState;

	@Override
	public void update(Subject subject) {
		myState = ((ConcreteSubject) subject).getState();

	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}
	
}
