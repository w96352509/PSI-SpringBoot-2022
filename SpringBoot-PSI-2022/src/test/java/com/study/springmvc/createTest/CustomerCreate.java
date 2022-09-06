package com.study.springmvc.createTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Customer;
import com.study.springmvc.repository.CustomerRepository;

@SpringBootTest
public class CustomerCreate {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void test() {
		
		Customer customer = new Customer();
		customer.setName("KL");
		customer.setNumber("0989022745");
		customer.setAddress("台北市信義路4號11-2");
		customerRepository.save(customer);
	}
	
}
