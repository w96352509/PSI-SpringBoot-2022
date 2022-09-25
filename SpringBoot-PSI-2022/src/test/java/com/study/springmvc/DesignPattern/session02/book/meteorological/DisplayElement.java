package com.study.springmvc.DesignPattern.session02.book.meteorological;

public interface DisplayElement {

	void display(); // 當佈告版需要顯示資料時使用 , 因每個佈告版資料都不同 , 所以獨立出來
	
}
