package com.study.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.entity.view.Inventory;
import com.study.springmvc.repository.ProductRepository;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/")
	public String view(Model model) {
		List<List<Inventory>> list = new ArrayList<>();
		list.add(productRepository.queryInventories());
		model.addAttribute("inventories" , productRepository.queryInventories());
		
		return "report";
	}
	
	
	
}
