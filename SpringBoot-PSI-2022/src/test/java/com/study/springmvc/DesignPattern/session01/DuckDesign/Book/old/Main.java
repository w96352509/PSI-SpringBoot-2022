package com.study.springmvc.DesignPattern.session01.DuckDesign.Book.old;

public class Main {

	public static void main(String[] args) {
		Duck rubberDuck = new RubberDuck();
		rubberDuck.display();
		rubberDuck.total();
		
		Duck redduck = new ReadHeadDuck();
		redduck.display();
		redduck.total();
	}
	
}
