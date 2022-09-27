package com.study.springmvc.DesignPattern.session02.phone;

import java.util.ArrayList;
import java.util.List;

import com.study.springmvc.DesignPattern.session02.phone.PhoneFactory.Phone;
import com.study.springmvc.DesignPattern.session02.phone.PhoneFactory.sys;

public class Main {

	public static void main(String[] args) {
		List<Phone> phones = new ArrayList<>();
		phones.add(Phone.myPhone);
		phones.add(Phone.myPhone);
		PhoneFactory phoneFactory = new PhoneFactory();
		phoneFactory.setSystemAndPhoneType(sys.ASystem,phones);
	}
	
}
