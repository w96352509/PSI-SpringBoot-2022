package com.study.springmvc.DesignPattern.session02.book.meteorological2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {

	private float temp;
	private float humidity;
	private float pressure;
	private String value;
	
	public WeatherData(String value) {
		this.value = value;
	}

	public void measurementsChanged() {
		setChanged();           // 紀錄
		notifyObservers(value); // 提取 ()
		notifyObservers();      // (拉取) 資料物件
	}

	public void setMeasurements(float temp , float humidity , float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
        measurementsChanged();		
	}
	
	
	
	// get...
	public float getTemp() {
		return temp;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

	
	
	
	
}
