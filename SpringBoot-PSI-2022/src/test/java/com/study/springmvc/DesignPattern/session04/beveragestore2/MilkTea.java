package com.study.springmvc.DesignPattern.session04.beveragestore2;

public class MilkTea implements Drink {

	private double value = 20;
	private IDiscountStrategy discountStrategy;
	
	public MilkTea(IDiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}
	
	@Override
	public double getValue() {
		return discountStrategy.getValue(value);
	}

}
