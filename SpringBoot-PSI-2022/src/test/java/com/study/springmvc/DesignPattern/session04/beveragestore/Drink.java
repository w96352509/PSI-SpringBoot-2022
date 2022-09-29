package com.study.springmvc.DesignPattern.session04.beveragestore;

public abstract class Drink {

	// 預設無折扣帶 1
    IDiscountStrategy discountStrategy = new NoneDiscount(1);

    // 飲料價格
    double value;

    // 刻意使用 private 讓子類都必須帶入 value 
    private Drink(){}

    // 純飲料價格
    public Drink(double value) {
        this.value = value;
    }

    // 飲料價格 + 特價方案
    public Drink(double value , IDiscountStrategy discountStrategy) {
        this.value = value;
        this.discountStrategy = discountStrategy;
    }

    // 取得特價價格
    public double getValue() {
        return discountStrategy.getValue(value);
    }

}
