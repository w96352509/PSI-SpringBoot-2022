package com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New;

import com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New.Interface.Fly;
import com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New.Interface.Quack;

public abstract class Duck {

	private Fly fly;
	
	private Quack quack;
	
	public void setFunction(FType ftype , QType qType) {
		switch (qType) {
		case YQ:
			this.quack = new YQuack();
			break;

		case NQ:
			this.quack = new NQuack();
			break;
		}
		
		switch (ftype) {
		case YF:
			this.fly = new YFly();
			break;

		case NF:
			this.fly = new NFly();
			break;
		}
	}
	
	enum FType{
		YF , NF
	}
	
	enum QType{
		YQ , NQ 
	}
	
	private void swim() {
		System.out.println("游");
	}
	
	public abstract void display();
	
	public void total() {
		swim();
		display();
		fly.fly();
		quack.quack();
	}
	
}
