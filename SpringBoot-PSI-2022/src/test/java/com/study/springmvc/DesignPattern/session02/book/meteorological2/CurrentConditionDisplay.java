package com.study.springmvc.DesignPattern.session02.book.meteorological2;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer , DisplayElement {
	private float temp;
	private float humidity;
	Observable observable;
	
	public CurrentConditionDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("CurrentConditionDisplay :" + temp + "濕度:" + humidity);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {  // 如果 Observable 是 Weather 的訂閱者
			WeatherData weatherData = (WeatherData)o;
			this.temp = weatherData.getTemp();
			this.humidity = weatherData.getHumidity();
			System.out.println(arg);
			display();
		}
	}

	

}
