package com.study.springmvc.DesignPattern.session02.book.meteorological;

public class Main {

	public static void main(String[] args) {
		Subject weatherData = new WeatherData();
		CurrentConditionDisplay conditionDisplay = new CurrentConditionDisplay(weatherData);
		((WeatherData)weatherData).setMeasurements(80, 65, 30);
	}
	
}
