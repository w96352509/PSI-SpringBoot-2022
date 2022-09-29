package com.study.springmvc.DesignPattern.session04.beveragestore;

public class Main {

	public static void main(String[] args) {
		DrinkOrder drinkOrder = new DrinkOrder();
        drinkOrder.addDrink(new MilkTea(55,new MinusDiscount(20)));
        double price = drinkOrder.getTotalPrice(new NoneDiscount(2));
        System.out.println(price);
        
        //打九折
        price = drinkOrder.getTotalPrice(new MultiplyStrategy(0.9));
        System.out.println(price);
	}
	
}
