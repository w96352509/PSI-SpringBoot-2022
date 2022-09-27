package com.study.springmvc.DesignPattern.session01.BeverageShop;

public class SetDrink {

	private SugarType sugar;
    private IceType ice;
	
    
    public SetDrink() {
		
	}
    
    public SetDrink(SugarType sugar, IceType ice) {
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
