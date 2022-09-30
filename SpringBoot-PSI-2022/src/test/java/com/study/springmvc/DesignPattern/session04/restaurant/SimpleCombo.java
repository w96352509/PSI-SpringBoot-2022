package com.study.springmvc.DesignPattern.session04.restaurant;

public class SimpleCombo extends BusinessLunch {

	public SimpleCombo(Restaurant restaurant) {
		super(restaurant);
	}

    private void soup(){
        System.out.println("一份湯品");
    }

    @Override
    public void order() {
        super.order();
        soup();
    }
}
