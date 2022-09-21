package com.study.springmvc.Bean;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;


@Configurable
public class HelloConfig {

	
	public String message() {
		return "hello";
	}
	
}
