package com.study.springmvc.DesignPattern.session04.beveragestore2;

public class MinusDiscount implements IDiscountStrategy {

	private double discount;
	
	public MinusDiscount(double discount) {
		this.discount = discount;
	}

   @Override
	public double getValue(double value) {
		
		return value - discount;
	}

}
