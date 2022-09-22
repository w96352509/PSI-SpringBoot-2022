package com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New;

import com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New.Duck.FType;
import com.study.springmvc.DesignPattern.session01.DuckDesign.Book.New.Duck.QType;

public class Main {

	public static void main(String[] args) {
		Duck rubberDuck = new RubberDuck();
		rubberDuck.setFunction(FType.NF , QType.NQ );
		rubberDuck.total();
		
	}
	
}
