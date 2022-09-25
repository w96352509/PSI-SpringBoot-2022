package com.study.springmvc.DesignPattern.session02.book.meteorological;

import java.util.ArrayList;

public class WeatherData implements Subject {

	private ArrayList<Observer> observers = new ArrayList<>(); // 多個訂閱者
	private float temp;
	private float humidity;
	private float pressure;
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0) {
			observers.remove(i);
		}
		
	}

	@Override
	public void notifyObserver() {
		for(int i = 0; i < observers.size() ; i++) {
			Observer observer = observers.get(i);
			observer.update(temp, humidity, pressure); 
		}
	}
	
	public void measurementsChanged() { // 通知觀察者
      notifyObserver();		
	}

	public void setMeasurements(float temp , float humidity , float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	
}
