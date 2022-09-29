package com.study.springmvc.DesignPattern.session04.beveragestore2;

import com.study.springmvc.DesignPattern.session04.beveragestore2.DrinkOrder.DrinkMenu;

public class Main {

	public static void main(String[] args) {
		
		DrinkOrder drinkOrder = new DrinkOrder();
		drinkOrder.addDrink(drinkOrder.setDrink(DrinkMenu.MilkTea, new MinusDiscount(10)));
		System.out.println(drinkOrder.getTotalPrice(new NoneDiscount()));
	}
}
