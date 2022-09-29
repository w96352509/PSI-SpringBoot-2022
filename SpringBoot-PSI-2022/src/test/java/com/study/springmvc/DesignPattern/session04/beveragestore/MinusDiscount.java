package com.study.springmvc.DesignPattern.session04.beveragestore;

public class MinusDiscount extends IDiscountStrategy {


	public MinusDiscount(double discount) {
		super(discount);
	}

	@Override
	public double getValue(double value) {
		return value - discount;
	}

}
