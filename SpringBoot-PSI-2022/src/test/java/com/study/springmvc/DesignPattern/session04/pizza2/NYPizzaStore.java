package com.study.springmvc.DesignPattern.session04.pizza2;



public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		if (type.equals("葛利")) {
			return new ClamPizza();
		}
		    return null;
	}

}
