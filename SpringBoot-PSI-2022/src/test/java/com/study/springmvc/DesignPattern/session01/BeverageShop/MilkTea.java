package com.study.springmvc.DesignPattern.session01.BeverageShop;

public class MilkTea extends SetDrink implements Drink {

	SugarType sugarType;
	IceType ice;
	
	public MilkTea(SugarType sugarType, IceType ice) {
		this.sugarType = sugarType;
		this.ice = ice;
	}

    @Override
	public void getDrinks() {
		 System.out.println("奶茶甜度:" + sugarType +"冰塊" + ice);	
	}

}
