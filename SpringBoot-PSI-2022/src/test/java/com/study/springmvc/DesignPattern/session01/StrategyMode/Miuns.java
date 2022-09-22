package com.study.springmvc.DesignPattern.session01.StrategyMode;

public class Miuns implements IStrategy {

	@Override
	public int caculate(int a, int b) {
		return a - b;
	}

}
