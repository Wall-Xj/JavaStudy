package com.xj.observer2;

import java.util.Observable;

public class ConcreteSubject extends Observable {
	private int state;
	
	public void set(int s){
		state = s;
		setChanged();
		notifyObservers(state);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
