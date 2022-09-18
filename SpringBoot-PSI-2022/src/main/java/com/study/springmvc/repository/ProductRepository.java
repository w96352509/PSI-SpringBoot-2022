package com.study.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.study.springmvc.entity.Product;
import com.study.springmvc.entity.view.Inventory;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	// amount1 : 進貨數量
	// amount2 : 銷售數量
	
	
	@Query(nativeQuery = true,
			   value = "SELECT p.id, p.name, p.cost, p.price, \n" + 
			   		"(SELECT sum(amount) FROM purchase_item WHERE product_id = p.id limit 1) as amount1, \n" + 
			   		"(SELECT sum(amount) FROM order_item WHERE product_id = p.id limit 1) as amount2 \n" +
			   		"FROM product p")
		List<Inventory> queryInventories();
		
		@Query(nativeQuery = true,
				   value = "SELECT p.id, p.name, p.cost, p.price, \n" + 
				   		"(SELECT sum(amount) FROM purchase_item WHERE product_id = p.id limit 1) as amount1, \n" + 
				   		"(SELECT sum(amount) FROM order_item WHERE product_id = p.id limit 1) as amount2 \n" + 
				   		"FROM product p WHERE p.id=:id")
		Inventory findInventoryById(Long id);
	
}
