package com.study.springmvc.DesignPattern.session02.Drink;

// 類似工廠
public class DrinkShop {
	public Drink order(String drink,Drink.SugarType sugarType, Drink.IceType iceType){
        drink.toLowerCase();
        switch (drink){
            case "coffee":
                return new Coffee(sugarType,iceType);
            case "tea":
                return new Tea(sugarType,iceType);
            default:
                return null;
        }
    }
}
