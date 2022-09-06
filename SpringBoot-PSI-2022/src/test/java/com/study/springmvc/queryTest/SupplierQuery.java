package com.study.springmvc.queryTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.study.springmvc.entity.Supplier;
import com.study.springmvc.repository.SupplierRepository;


@SpringBootTest
public class SupplierQuery {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Test
	public void test() {
		Supplier supplier = supplierRepository.findById(1L).get();
		System.out.println(supplier.getName());
	}
	
}
