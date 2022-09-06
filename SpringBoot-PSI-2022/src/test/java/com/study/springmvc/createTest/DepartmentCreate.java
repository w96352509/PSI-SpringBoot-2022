package com.study.springmvc.createTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Customer;
import com.study.springmvc.entity.Department;
import com.study.springmvc.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentCreate {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	public void test() {
		
		Department department = new Department();
		department.setManager("C-Block");
		department.setName("RAP");
		departmentRepository.save(department);
	}
	
}
