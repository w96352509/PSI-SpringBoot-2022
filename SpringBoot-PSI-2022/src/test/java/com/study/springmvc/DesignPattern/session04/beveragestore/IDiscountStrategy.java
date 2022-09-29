package com.study.springmvc.DesignPattern.session04.beveragestore;

// 折價策略的介面
public abstract class IDiscountStrategy {

	double discount; // 折扣價錢

    private IDiscountStrategy(){} // 刻意使用 private 讓子類都必須帶入 discount

    
    public IDiscountStrategy(double discount){
        this.discount = discount;
    }

    // 需實踐方法
    abstract public double getValue(double value);
	
}
