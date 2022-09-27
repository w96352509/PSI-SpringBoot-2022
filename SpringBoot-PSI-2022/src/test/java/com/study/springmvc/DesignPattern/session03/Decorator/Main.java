package com.study.springmvc.DesignPattern.session03.Decorator;

public class Main {
	public static void main(String[] args) {
      Beverage beverage = new HouseBlend();
      beverage = new Mocha(beverage);
      System.out.println(beverage.getDescription() + beverage.cost());
      
      Beverage beverage2 = new DarkRoast();
      System.out.println(beverage2.getDescription() + beverage2.cost());
	}
}
