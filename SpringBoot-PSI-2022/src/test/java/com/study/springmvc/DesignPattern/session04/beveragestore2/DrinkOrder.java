package com.study.springmvc.DesignPattern.session04.beveragestore2;

import java.util.ArrayList;
import java.util.List;

public class DrinkOrder {

	//放飲料的list
    private List<Drink> drinkList = new ArrayList<Drink>();

    //加入飲料
    public void addDrink(Drink drink){
        drinkList.add(drink);
    }
	//移除飲料
    public void removeDrink(Drink drink){
        drinkList.remove(drink);
    }
	
    public Drink setDrink(DrinkMenu menu , IDiscountStrategy iDiscountStrategy) {
    	switch (menu) {
		case MilkTea:
			return new MilkTea(iDiscountStrategy);
		default:
			return null;
		}
    }
    
    enum DrinkMenu{MilkTea};
    
    private double totalPrice(){

        double totalPrice = 0 ;

        for(Drink d:drinkList){
            totalPrice += d.getValue();
        }

        return totalPrice;

    }
    
    public double getTotalPrice(IDiscountStrategy discountStrategy){

        double totalPrice = totalPrice() ;

        return discountStrategy.getValue(totalPrice);

    }
    
}
