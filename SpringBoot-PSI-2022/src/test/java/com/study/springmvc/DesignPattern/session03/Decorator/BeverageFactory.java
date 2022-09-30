package com.study.springmvc.DesignPattern.session03.Decorator;

import java.util.ArrayList;
import java.util.List;

public class BeverageFactory {

	Beverage beverage;
	
	public String getBeverage(Beveragemenu name) {
		switch (name) {
		case HouseBlend:
			beverage = new HouseBlend();
			return beverage.getDescription() + "價錢:" + beverage.cost();

		case DarkRoast:
			beverage = new DarkRoast();
			return beverage.getDescription() + "價錢:" + beverage.cost();

		default:
			return null;
		}

	}

	public String getBeverageAndCondimentDecorator(Beveragemenu name , CondimentDecoratormenu cond) {
		getBeverage(name);
		switch (cond) {
		
		case Mocha:
			beverage = new Mocha(beverage);
			return beverage.getDescription() + "價錢:" + beverage.cost();
		
		case Milk:
			beverage = new Milk(beverage);
			return beverage.getDescription() + "價錢:" + beverage.cost();	
			
		default:
			return null;
		}

	}

	enum Beveragemenu {
		HouseBlend, DarkRoast
	}

	enum CondimentDecoratormenu {
		Mocha , Milk
	}
}
