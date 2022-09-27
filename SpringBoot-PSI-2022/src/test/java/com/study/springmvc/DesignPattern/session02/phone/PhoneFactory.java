package com.study.springmvc.DesignPattern.session02.phone;

import java.util.List;

public class PhoneFactory {

	private Subject subject;
	
	// 輸入目前版本(主題) + 手機清單(訂閱者們)
	public void setSystemAndPhoneType(sys name , List<Phone> phones) {
		switch (name) {
		case ASystem:
			// 順序不可更改
			ASystem aSystem = new ASystem();
			this.subject = aSystem;
			for(Phone phone : phones) {
				getPhone(phone);
			}
			aSystem.setInformation("A系統", "1.1");
			break;
        default:
			
		}
	}
	
	 private Observer getPhone(Phone name) {
		switch (name) {
		case myPhone:
			return new myPhone(subject);
		default:
			return null;
		}
	}
	
	enum Phone{myPhone}
	
	enum sys{ASystem}
}
