package com.study.springmvc.DesignPattern.session03.Decorator;

public abstract class Beverage  {
	// 上有 cost()
	String description = "Unknow Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
	
}
