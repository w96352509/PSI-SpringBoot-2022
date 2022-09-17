package com.study.springmvc.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.study.springmvc.entity.Purchase;
import com.study.springmvc.entity.PurchaseItem;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
