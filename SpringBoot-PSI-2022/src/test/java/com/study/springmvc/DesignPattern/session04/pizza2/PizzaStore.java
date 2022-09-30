package com.study.springmvc.DesignPattern.session04.pizza2;

public abstract class PizzaStore {

	public Pizza PizzaOrder(String type) {
		 Pizza pizza = createPizza(type);
		 pizza.prepare();
		 pizza.back();
		 pizza.cut();
		 pizza.box();
		 pizza.pizzaType();
		 return pizza;
	}
	
	abstract Pizza createPizza(String type); // 此方法類似工廠來 new 不同的 Pizza
	
}
