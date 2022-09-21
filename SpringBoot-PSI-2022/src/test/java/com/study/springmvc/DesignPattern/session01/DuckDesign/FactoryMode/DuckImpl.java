package com.study.springmvc.DesignPattern.session01.DuckDesign.FactoryMode;

public class DuckImpl implements Duck {

	String type = "普通鴨";
	
	public DuckImpl() {
		
	}
	
	public DuckImpl(String type) {
		this.type = type;
	}

    @Override
	public void NarrativeDuck() {
		System.out.println("產出:" + type + "的品種鴨");
	}

}
