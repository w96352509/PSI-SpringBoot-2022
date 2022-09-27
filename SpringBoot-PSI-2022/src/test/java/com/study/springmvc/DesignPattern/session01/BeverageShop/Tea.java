package com.study.springmvc.DesignPattern.session01.BeverageShop;

public class Tea extends SetDrink implements Drink  {
	
	SugarType sugarType;
	IceType   ice;
	
	public Tea(SugarType sugarType, IceType ice) {
		this.sugarType = sugarType;
		this.ice = ice;
	}

    @Override
	public void getDrinks() {
       System.out.println("Tea甜度:" + sugarType +"冰塊" + ice);		
	}
}
