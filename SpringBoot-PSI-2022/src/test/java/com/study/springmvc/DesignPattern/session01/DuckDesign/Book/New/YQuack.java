package com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New;

import com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New.Interface.Quack;

public class YQuack implements Quack {

	@Override
	public void quack() {
		System.out.println("大眾鴨叫聲");
		}

}
