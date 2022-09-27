package com.study.springmvc.DesignPattern.session03.SingletonFactory;

public class Product {
	public String getName(){
        return this.getClass().getSimpleName();
    }
}
