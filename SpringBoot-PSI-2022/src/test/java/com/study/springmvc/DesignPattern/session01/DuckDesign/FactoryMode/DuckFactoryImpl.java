package com.study.springmvc.DesignPattern.session01.DuckDesign.FactoryMode;

public class DuckFactoryImpl implements DuckFactory{

	@Override
	public Duck getDuck() {
		return new DuckImpl() ;
	}
	
	// 超載
	public Duck getDuck(String type) {
		return new DuckImpl(type) ;
	}
}
