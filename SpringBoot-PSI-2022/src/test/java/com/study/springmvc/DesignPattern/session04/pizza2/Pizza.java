package com.study.springmvc.DesignPattern.session04.pizza2;

public abstract class Pizza {

	public abstract void pizzaType();
	
	public void prepare() {
		System.out.println("準備");
	}
	
	public void back() {
		System.out.println("烘焙");
	}
	
	public void cut() {
		System.out.println("切");
	}
	
	public void box() {
		System.out.println("包裝");
	}
		
}
