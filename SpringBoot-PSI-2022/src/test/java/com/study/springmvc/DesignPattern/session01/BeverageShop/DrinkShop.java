package com.study.springmvc.DesignPattern.session01.BeverageShop;

import com.study.springmvc.DesignPattern.session01.BeverageShop.SetDrink.IceType;
import com.study.springmvc.DesignPattern.session01.BeverageShop.SetDrink.SugarType;

public class DrinkShop {

	// 策略模式
	public void order2(Drink drink) {
		drink.getDrinks();
	}
	
	public Drink order(String drink , SugarType sugar , IceType ice) {
		switch (drink) {
		case "tea":
			return new Tea(sugar,ice);
		
		case "Milk":
			return new MilkTea(sugar,ice);	
			
        default:
			return null;
		}
	}
	//
}
