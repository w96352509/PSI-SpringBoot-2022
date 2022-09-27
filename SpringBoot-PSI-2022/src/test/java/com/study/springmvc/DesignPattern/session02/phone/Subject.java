package com.study.springmvc.DesignPattern.session02.phone;


public interface Subject {
	 void registerObserver(Observer o); // 註冊觀察者
	 void removeObserver(Observer o);   // 刪除觀察者
	 void notifyObserver();   // 當主題更改時呼叫 , 通知所有 Observer
}
