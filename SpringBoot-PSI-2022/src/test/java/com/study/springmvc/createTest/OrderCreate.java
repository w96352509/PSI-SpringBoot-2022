package com.study.springmvc.createTest;

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
public class OrderCreate {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void test() {
		
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +7);
        Date todate1 = cal.getTime(); 
		
	    Order order = new Order();
	    order.setDate(new Date());
	    order.setExpectedDate(todate1);
	    order.setCustomer(customerRepository.findById(1L).get());
	    order.setEmployee(employeeRepository.findById(1L).get());
	    orderRepository.save(order);
	}
	
}
