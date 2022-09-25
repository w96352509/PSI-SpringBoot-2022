package com.study.springmvc.DesignPattern.session02.book.practise;

import java.util.ArrayList;

public class SubjectImpl implements Subject {

	String videoName;
	
	ArrayList<Observer> observers = new ArrayList<>();
	
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0) observers.remove(i);
	}

	@Override
	public void noticeObserver() {
		for(int i=0; i<observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(videoName);
		}
	}
	
	public void setVideoName(String name) {
	   this.videoName = name;
	   noticeObserver();
	}
	

	 
	
}
