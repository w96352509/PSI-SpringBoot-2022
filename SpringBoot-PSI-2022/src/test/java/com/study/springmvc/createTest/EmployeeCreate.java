package com.study.springmvc.createTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Customer;
import com.study.springmvc.entity.Employee;
import com.study.springmvc.repository.DepartmentRepository;
import com.study.springmvc.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeCreate {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	public void test() {
		
		Employee employee = new Employee();
		employee.setName("Dame");
		employee.setDepartment(departmentRepository.findById(1L).get());
		employeeRepository.save(employee);
	}
	
}
