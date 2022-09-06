package com.study.springmvc.queryTest;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springmvc.entity.Order;
import com.study.springmvc.entity.Purchase;
import com.study.springmvc.entity.PurchaseItem;
import com.study.springmvc.repository.CustomerRepository;
import com.study.springmvc.repository.EmployeeRepository;
import com.study.springmvc.repository.OrderRepository;
import com.study.springmvc.repository.ProductRepository;
import com.study.springmvc.repository.PurchaseItemRepository;
import com.study.springmvc.repository.PurchaseRepository;
import com.study.springmvc.repository.SupplierRepository;

@SpringBootTest
public class PurchaseItemQuery {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private PurchaseItemRepository purchaseItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void test() {
	  
		PurchaseItem purchaseItem = purchaseItemRepository.findById(3L).get();
		System.out.println(purchaseItem.getAmount());
		System.out.println(purchaseItem.getProduct().getName());
		System.out.println(purchaseItem.getPurchase().getEmployee().getName());
	   
	
	}
	
}
