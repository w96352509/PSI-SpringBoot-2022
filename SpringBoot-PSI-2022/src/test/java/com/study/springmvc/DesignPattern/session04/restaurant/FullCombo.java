package com.study.springmvc.DesignPattern.session04.restaurant;

public class FullCombo extends SimpleCombo {

    public FullCombo(Restaurant restaurant) {
        super(restaurant);
    }

    private void sweet(){
        System.out.println("一份甜點");
    }

    @Override
    public void order() {
        super.order();
        sweet();
    }
}
