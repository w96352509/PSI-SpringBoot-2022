package com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New;

public class Main {

	public static void main(String[] args) {
		Duck RubberDuck = new RubberDuck();
		RubberDuck.total(new NFly(), new YQuack());
	}
	
}
