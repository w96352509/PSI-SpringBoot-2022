package com.study.springmvc.DesignPattern.session04.pizza;

public class Main {

	public static void main(String[] args) {
	  PizzaStore pizzaStore = new PizzaStore(new SimpleFactory());
	  pizzaStore.PizzaOrder("葛利");
	}
}
