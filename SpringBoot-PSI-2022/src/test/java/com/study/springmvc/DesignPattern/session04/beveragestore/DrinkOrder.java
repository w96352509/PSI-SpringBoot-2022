package com.study.springmvc.DesignPattern.session04.beveragestore;

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

    //飲料總價錢（私有方法）
    private double totalPrice(){

        double totalPrice = 0 ;

        for(Drink d:drinkList){
            totalPrice += d.getValue();
        }

        return totalPrice;

    }

    //訂單總價錢
    public double getTotalPrice(IDiscountStrategy discountStrategy){

        double totalPrice = totalPrice() ;

        return discountStrategy.getValue(totalPrice);

    }
}
