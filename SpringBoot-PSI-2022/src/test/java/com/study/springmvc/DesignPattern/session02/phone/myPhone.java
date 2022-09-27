   package com.study.springmvc.DesignPattern.session02.phone;

public class myPhone implements Observer {
	private Subject subject;
	
	public myPhone(Subject subject) {
		subject.registerObserver(this);
	}
   
	@Override
	public void update(String name, String version) {
      System.out.println("系統名稱"+ name +"手機版本 " + version +" 手機名稱A");	  	
	}
}
