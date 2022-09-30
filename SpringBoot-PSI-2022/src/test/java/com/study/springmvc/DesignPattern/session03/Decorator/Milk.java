package com.study.springmvc.DesignPattern.session03.Decorator;

public class Milk extends CondimentDecorator {
    Beverage beverage; // 紀錄被裝飾者
	
    public Milk(Beverage beverage) { // 讓被裝飾者進入實體中
		this.beverage = beverage; 
	}

	@Override
	public String getDescription() {
		
		return beverage.getDescription()+", Milk";
	}

	@Override
	public double cost() {
		
		return .20+beverage.cost(); // 價格 + 被裝飾者的價格
	}

}
