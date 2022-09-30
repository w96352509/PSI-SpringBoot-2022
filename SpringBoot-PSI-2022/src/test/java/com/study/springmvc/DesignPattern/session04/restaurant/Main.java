package com.study.springmvc.DesignPattern.session04.restaurant;

public class Main {

	public static void main(String[] args) {
	  Restaurant restaurant = new Restaurant();
	  restaurant = new BusinessLunch(restaurant);
	  restaurant = new SimpleCombo(restaurant);
	  restaurant = new FullCombo(restaurant);
	  restaurant.order();
	}	
}
