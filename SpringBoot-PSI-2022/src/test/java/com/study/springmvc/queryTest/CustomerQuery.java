package com.study.springmvc.queryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Customer;
import com.study.springmvc.repository.CustomerRepository;

@SpringBootTest
public class CustomerQuery {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void test() {
		Customer customer = customerRepository.findById(1L).get();
		System.out.println(customer.getName());
	}
	
}
