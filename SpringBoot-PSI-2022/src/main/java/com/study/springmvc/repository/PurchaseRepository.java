package com.study.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springmvc.entity.Purchase;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
