package com.study.springmvc.DesignPattern.session02.book.practise;

public interface Subject {

	void addObserver(Observer o);
	
	void removeObserver(Observer o);
	
	void noticeObserver();
	
}
