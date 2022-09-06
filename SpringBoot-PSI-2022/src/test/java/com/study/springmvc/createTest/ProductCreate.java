package com.study.springmvc.createTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Product;
import com.study.springmvc.repository.ProductRepository;



@SpringBootTest
public class ProductCreate {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void test() {
		
		Product product = new Product();
	    product.setName("商品01");
	    product.setCost(100);
	    product.setPrice(200);
	    product.setNotice("無");
	    productRepository.save(product);
	}
	
}
