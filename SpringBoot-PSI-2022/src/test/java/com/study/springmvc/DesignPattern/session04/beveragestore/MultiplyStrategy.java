package com.study.springmvc.DesignPattern.session04.beveragestore;

public class MultiplyStrategy extends IDiscountStrategy {

	// 只要没有用super关键字，都会默认调用父类的无参构造方法
	// 解決方案 :
	// 1. 父类中写一个空方法或者删除父类的所有构造方
	// 2. 用 super 調用自身沒有的變數(此用2)
	
	public MultiplyStrategy(double discount) {
		super(discount);
	}

	@Override
	public double getValue(double value) {
		return value * discount;
	}

}
