package com.study.springmvc.DesignPattern.session02.book.meteorological;

public interface Observer {

	// 當氣象數據改變 , Subject 會把這些參數傳給 Observer
	void update(float temp , float humidity , float pressure);
	
	
}
