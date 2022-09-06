package com.study.springmvc.queryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.study.springmvc.entity.Employee;
import com.study.springmvc.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeQuery {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@Test
	public void test() {
		
		Employee employee = employeeRepository.findById(1L).get();
		System.out.println(employee.getName());
		System.out.println(employee.getDepartment().getName());
	}
	
}
