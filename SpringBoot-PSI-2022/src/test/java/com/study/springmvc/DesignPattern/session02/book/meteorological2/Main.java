package com.study.springmvc.DesignPattern.session02.book.meteorological2;

import java.util.Observer;

public class Main {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData("123");
		CurrentConditionDisplay observer = new CurrentConditionDisplay(weatherData);
		weatherData.setMeasurements(100, 80, 100);
	}
	
}
