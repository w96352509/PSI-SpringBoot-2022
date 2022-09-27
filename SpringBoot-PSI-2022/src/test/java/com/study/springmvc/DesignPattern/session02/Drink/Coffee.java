package com.study.springmvc.DesignPattern.session02.Drink;

public class Coffee extends Drink {
	
	private CoffeeType coffeeType;

    public Coffee(SugarType sugar, IceType ice) {
    	super(sugar, ice);
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    enum CoffeeType{
        LATTE,MOCHA,WHITE,BLUE_MOUNTAIN,AMERICANO,ESPRESSO
    }

	@Override
	public String toString() {
		return "Coffee [coffeeType=" + coffeeType +" "+ "sugar="+ sugar+" " + "ice=" + ice +"]";
	}
    
    
}
