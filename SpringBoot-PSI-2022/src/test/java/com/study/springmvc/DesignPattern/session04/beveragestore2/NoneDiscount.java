package com.study.springmvc.DesignPattern.session04.beveragestore2;

public class NoneDiscount implements IDiscountStrategy {

	public NoneDiscount() {
		
	}
	
	@Override
	public double getValue(double value) {
		return value;
	}

}
