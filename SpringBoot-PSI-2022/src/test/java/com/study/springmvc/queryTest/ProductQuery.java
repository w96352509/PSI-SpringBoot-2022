package com.study.springmvc.queryTest;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Product;
import com.study.springmvc.entity.view.Inventory;
import com.study.springmvc.repository.ProductRepository;



@SpringBootTest
public class ProductQuery {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void test() {
		 Inventory inventory = productRepository.findInventoryById(1L);
		 System.out.println(inventory.getAmount1());
		 System.out.println(inventory.getAmount2());
	}
	
}
