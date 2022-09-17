package com.study.springmvc.queryTest;

import java.util.List;
import java.util.stream.Collectors;

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
		
		 List<String> supName = productRepository.findById(1L).get().getPurchaseItems().stream().map(c->c.getPurchase().getSupplier().getName()).collect(Collectors.toList());
		 for(String s : supName) {
			 System.out.println(s);
		 }
	}
	
}
