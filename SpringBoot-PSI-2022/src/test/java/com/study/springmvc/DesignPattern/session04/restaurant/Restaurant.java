package com.study.springmvc.DesignPattern.session04.restaurant;

public class Restaurant {

    private void minimumOrder(){
        System.out.println("一杯飲料");
    }

    //低消是一杯飲料
    public void order(){
        minimumOrder();
    }

}
