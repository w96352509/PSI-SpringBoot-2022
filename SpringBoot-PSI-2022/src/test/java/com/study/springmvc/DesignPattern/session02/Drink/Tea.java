package com.study.springmvc.DesignPattern.session02.Drink;

public class Tea extends Drink {
	TeaType teaType;

    public Tea(SugarType sugar, IceType ice) {
        super(sugar, ice);
    }

    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }

    public TeaType getTeaType() {
        return teaType;
    }

    enum TeaType{
        LEMON,OOLONG,GINGER,HONEY
    }
}
