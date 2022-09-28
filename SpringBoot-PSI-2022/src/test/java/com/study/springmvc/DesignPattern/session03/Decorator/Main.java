package com.study.springmvc.DesignPattern.session03.Decorator;

import com.study.springmvc.DesignPattern.session03.Decorator.BeverageFactory.Beveragemenu;
import com.study.springmvc.DesignPattern.session03.Decorator.BeverageFactory.CondimentDecoratormenu;

public class Main {
	public static void main(String[] args) {
      BeverageFactory beverageFactory = new BeverageFactory();
      System.out.println(beverageFactory.getBeverageAndCondimentDecorator(Beveragemenu.HouseBlend, CondimentDecoratormenu.Mocha));
     
	}
}
