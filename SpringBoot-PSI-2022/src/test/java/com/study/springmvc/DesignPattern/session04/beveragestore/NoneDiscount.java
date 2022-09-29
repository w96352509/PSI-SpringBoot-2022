package com.study.springmvc.DesignPattern.session04.beveragestore;

public class NoneDiscount extends IDiscountStrategy  {

	
	public NoneDiscount(double discount) {
		super(discount);
	}

	@Override
	public double getValue(double value) {
		return value;
	}

}
