package com.study.springmvc.DesignPattern.session02.book.meteorological;

public class CurrentConditionDisplay implements Observer , DisplayElement {

	private float temp;
	private float humidity;
	
	
	public CurrentConditionDisplay(Subject weatherData) {
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("CurrentConditionDisplay :" + temp + "濕度:" + humidity );
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		display();
	}

}
