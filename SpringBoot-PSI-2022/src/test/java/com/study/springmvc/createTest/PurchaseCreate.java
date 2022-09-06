package com.study.springmvc.createTest;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Order;
import com.study.springmvc.entity.Purchase;
import com.study.springmvc.repository.CustomerRepository;
import com.study.springmvc.repository.EmployeeRepository;
import com.study.springmvc.repository.OrderRepository;
import com.study.springmvc.repository.PurchaseRepository;
import com.study.springmvc.repository.SupplierRepository;

@SpringBootTest
public class PurchaseCreate {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void test() {
		
		Purchase purchase = new Purchase();
		purchase.setDate(new Date());
		purchase.setEmployee(employeeRepository.findById(1L).get());
		purchase.setSupplier(supplierRepository.findById(1L).get());
	    purchaseRepository.save(purchase);
	}
	
}
