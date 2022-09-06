package com.study.springmvc.createTest;

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
public class PurchaseItemCreate {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private PurchaseItemRepository purchaseItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void test() {
	  
		PurchaseItem purchaseItem = new PurchaseItem();
	    purchaseItem.setAmount(0);
	    purchaseItem.setProduct(productRepository.findById(1L).get());
	    purchaseItem.setPurchase(purchaseRepository.findById(1L).get());
	    purchaseItemRepository.save(purchaseItem);
	
	}
	
}
