package com.study.springmvc.DesignPattern.session01.BeverageShop;

import com.study.springmvc.DesignPattern.session01.BeverageShop.SetDrink.IceType;
import com.study.springmvc.DesignPattern.session01.BeverageShop.SetDrink.SugarType;

public class Main {

	public static void main(String[] args) {
		DrinkShop drinkShop = new DrinkShop();
		Drink drink = drinkShop.order("Milk",SugarType.FREE , IceType.EASY);
		drink.getDrinks();
		drinkShop.order2(new MilkTea(SugarType.FREE , IceType.EASY));
	}
	
}
