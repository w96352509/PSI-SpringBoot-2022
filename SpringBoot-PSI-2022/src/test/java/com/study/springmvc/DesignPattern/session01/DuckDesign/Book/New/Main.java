package com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New;

public class Main {

	public static void main(String[] args) {
		Duck duck = new RubberDuck();
		duck.total(new NFly(), new YQuack());
	}
	
}
