package com.study.springmvc.DesignPattern.session02.Drink;

public abstract class Drink {
    SugarType sugar;
    IceType ice;

    private Drink(){}

    public Drink(SugarType sugar, IceType ice) {
        this.sugar = sugar;
        this.ice = ice;
    }

    public SugarType getSugar() {
        return sugar;
    }

    public void setSugar(SugarType sugar) {
        this.sugar = sugar;
    }

    public IceType getIce() {
        return ice;
    }

    public void setIce(IceType ice) {
        this.ice = ice;
    }

    enum SugarType{
        REGULAR,LESS,HALF,QUARTER,FREE
    }

    enum IceType{
        REGULAR,EASY,FREE,HOT
    }

}
