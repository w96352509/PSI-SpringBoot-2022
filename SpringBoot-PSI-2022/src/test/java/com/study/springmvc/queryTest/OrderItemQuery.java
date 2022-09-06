package com.study.springmvc.queryTest;

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
public class OrderItemQuery {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Test
	public void test() {
		
		OrderItem orderItem = orderItemRepository.findById(1L).get();
		System.out.println(orderItem.getAmount());
		System.out.println(orderItem.getOrder().getDate());
		System.out.println(orderItem.getProduct().getName());
	}
	
}
