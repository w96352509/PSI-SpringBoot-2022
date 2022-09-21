package com.study.springmvc.DesignPattern.session01.DuckDesign.Book.old;

public abstract class Duck {

	public void quack() {
		System.out.println("呱呱叫");
	}
	
	private void swim() {
		System.out.println("游");
	}
	
	private void fly() {
		System.out.println("飛");
	}
	
	public abstract void display();
	
	public void total() {
		quack();
		swim();
		fly();
	}
	
}
