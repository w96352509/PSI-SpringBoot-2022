package com.study.springmvc.queryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Customer;
import com.study.springmvc.entity.Department;
import com.study.springmvc.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentQuery {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	public void test() {
		
		Department department = departmentRepository.findById(1L).get();
		System.out.println(department.getName());
	}
	
}
