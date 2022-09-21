package com.study.springmvc.Bean;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class helloTest {

	@Test
	public void test() {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloConfig.class);   // Annotation
		
		for(String s : ctx.getBeanDefinitionNames()) {
			System.out.println(s);
		}
	}
	
}
