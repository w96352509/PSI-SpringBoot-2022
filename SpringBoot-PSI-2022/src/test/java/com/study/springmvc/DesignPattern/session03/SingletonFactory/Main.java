package com.study.springmvc.DesignPattern.session03.SingletonFactory;

public class Main {

	public static void main(String[] args) {
	Cola cola   = (Cola)SingletonFactory.getColaFactory().getProduct();
	Humberger humberger = (Humberger)SingletonFactory.getHumbergerFactory().getProduct();
	System.out.println(cola.getName());
	System.out.println(humberger.getName());
	}
}
