package com.study.springmvc.createTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Customer;
import com.study.springmvc.entity.OrderItem;
import com.study.springmvc.repository.CustomerRepository;
import com.study.springmvc.repository.OrderItemRepository;
import com.study.springmvc.repository.OrderRepository;
import com.study.springmvc.repository.ProductRepository;

@SpringBootTest
public class OrderItemCreate {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Test
	public void test() {
		
		OrderItem orderItem = new OrderItem();
		orderItem.setAmount(10);
		orderItem.setOrder(orderRepository.findById(1L).get());
		orderItem.setProduct(productRepository.findById(1L).get());
		orderItemRepository.save(orderItem);
	}
	
}
