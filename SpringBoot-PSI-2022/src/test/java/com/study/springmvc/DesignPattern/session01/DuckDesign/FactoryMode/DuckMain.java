package com.study.springmvc.DesignPattern.session01.DuckDesign.FactoryMode;

public class DuckMain {

	public static void main(String[] args) {
	   DuckFactory duckFactory = new DuckFactoryImpl();
	   Duck duck  = duckFactory.getDuck();
	   // 超載
	   Duck duck2 = ((DuckFactoryImpl)duckFactory).getDuck("塑膠鴨");
	   duck.NarrativeDuck();
	   duck2.NarrativeDuck();
	}	
}
