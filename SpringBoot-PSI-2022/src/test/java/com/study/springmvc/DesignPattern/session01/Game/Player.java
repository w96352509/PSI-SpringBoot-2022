package com.study.springmvc.DesignPattern.session01.Game;

public class Player {

	private WeaponBehavior weaponBehavior;
    
	public void getWeapon2(WeaponBehavior weaponBehavior) {
		weaponBehavior.userWeapon();
	}
	
	public void getWeapon() {
		weaponBehavior.userWeapon();
	}
		
	public void setWeapon(Weapon weapon){
		switch (weapon) {
		case Sword:
			this.weaponBehavior = new SwordBehavior();
			break;

        case Bow:
        	this.weaponBehavior = new BowBehavior();
			break;
		}
	}

	enum Weapon{
		Sword , Bow
	}
	
}
