package com.study.springmvc.DesignPattern.session04.pizza;

public class PizzaStore {

	SimpleFactory simpleFactory ;

	public PizzaStore(SimpleFactory simpleFactory) {
		this.simpleFactory = simpleFactory;
	}
	
	public Pizza PizzaOrder(String type) {
		 Pizza pizza = simpleFactory.createPizza(type);
		 pizza.prepare();
		 pizza.back();
		 pizza.cut();
		 pizza.box();
		 pizza.pizzaType();
		 return pizza;
	}
	
}
