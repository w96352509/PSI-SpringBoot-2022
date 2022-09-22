package com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New;

import com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New.Interface.Fly;
import com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New.Interface.Quack;

public abstract class Duck {

	private void swim() {
		System.out.println("游");
	}
	
	public abstract void display();
	
	public void total(Fly fly , Quack quack) {
		swim();
		display();
		fly.fly();
		quack.quack();
	}
	
}
