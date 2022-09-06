package com.study.springmvc.queryTest;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Order;
import com.study.springmvc.repository.CustomerRepository;
import com.study.springmvc.repository.EmployeeRepository;
import com.study.springmvc.repository.OrderRepository;

@SpringBootTest
public class OrderQuery {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void test() {
		
		Order order = orderRepository.findById(1L).get();
		System.out.println(order.getDate());
		System.out.println(order.getCustomer().getName());
		System.out.println(order.getEmployee().getName());
	}
	
}
