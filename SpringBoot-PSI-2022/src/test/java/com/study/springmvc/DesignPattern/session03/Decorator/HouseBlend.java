package com.study.springmvc.DesignPattern.session03.Decorator;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "HouseBlend";
	}

	@Override
	public double cost() {
		return 1.99;
	}
	
	
	
}
