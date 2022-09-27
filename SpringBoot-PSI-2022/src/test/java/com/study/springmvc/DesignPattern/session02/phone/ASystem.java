package com.study.springmvc.DesignPattern.session02.phone;

import java.util.ArrayList;

// 系統
public class ASystem implements Subject {

	private ArrayList<Observer> observers = new ArrayList<>();
	private String name;
	private String version;
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObserver() {
        System.out.println("2.");
		for(int i = 0; i < observers.size() ; i++) {
			 Observer observer = observers.get(i);
			 observer.update(name, version);
		}
		
	}

	public void setInformation(String name , String version) {
		this.name = name;
		this.version  = version;
		System.out.println("1.");
		notifyObserver();
	}
	
}
