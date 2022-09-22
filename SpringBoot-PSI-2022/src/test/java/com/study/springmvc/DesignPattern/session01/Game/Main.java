package com.study.springmvc.DesignPattern.session01.Game;

import com.study.springmvc.DesignPattern.session01.Game.Player.Weapon;

public class Main {

	public static void main(String[] args) {
		Player player = new Player();
		player.setWeapon(Weapon.Bow);
		player.getWeapon();
		player.getWeapon2(new SwordBehavior());
	}
	
}
