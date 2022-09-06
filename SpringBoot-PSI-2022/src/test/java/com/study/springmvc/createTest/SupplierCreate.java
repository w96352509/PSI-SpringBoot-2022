package com.study.springmvc.createTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Customer;
import com.study.springmvc.entity.Supplier;
import com.study.springmvc.repository.SupplierRepository;

@SpringBootTest
public class SupplierCreate {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Test
	public void test() {
		Supplier supplier = new Supplier();
		supplier.setName("供應商TEST");
		supplierRepository.save(supplier);
	}
	
}
