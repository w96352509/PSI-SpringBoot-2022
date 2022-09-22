package com.study.springmvc.DesignPattern.session01.StrategyMode;

import com.study.springmvc.DesignPattern.session01.StrategyMode.Calculator.DoType;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setStrategy(DoType.MINUS);
		int i = calculator.execute(1, 2);
		System.out.println(i);
	}
	
}
