package com.study.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springmvc.entity.view.Inventory;
import com.study.springmvc.repository.ProductRepository;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/")
	public String view(Model model) {
		model.addAttribute("inventories" , productRepository.queryInventories());
	    return "inventory";
	}
	
	
}
