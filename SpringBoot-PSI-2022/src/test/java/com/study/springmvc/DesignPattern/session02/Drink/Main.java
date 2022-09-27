package com.study.springmvc.DesignPattern.session02.Drink;

public class Main {

	public static void main(String[] args) {
		DrinkShop drinkShop = new DrinkShop(); // 呼叫工廠
		
		// 由工廠產生咖啡
		Coffee coffee = (Coffee)drinkShop.order("coffee", Drink.SugarType.FREE, Drink.IceType.HOT);
		
		// 客製商品後自帶的功能設定
		coffee.setCoffeeType(Coffee.CoffeeType.AMERICANO);
        System.out.println(coffee.toString());
	}	
}
