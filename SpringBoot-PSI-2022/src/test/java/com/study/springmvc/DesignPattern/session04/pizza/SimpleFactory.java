package com.study.springmvc.DesignPattern.session04.pizza;

public class SimpleFactory {
	
	Pizza pizza;
	
	public Pizza createPizza(String type) {
		if (type.equals("葛利")) {
			pizza = new ClamPizza();
		}
		return pizza;
	}
	
}
