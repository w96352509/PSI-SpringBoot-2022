package com.study.springmvc.queryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Product;
import com.study.springmvc.repository.ProductRepository;



@SpringBootTest
public class ProductQuery {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void test() {
		
		Product product = productRepository.findById(1L).get();
		System.out.println(product.getName());
	    
	}
	
}
