package com.study.springmvc.DesignPattern.session03.Decorator;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "DarkRoast";
	}
	
	@Override
	public double cost() {
		return 0.54;
	}

}
