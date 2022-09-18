package com.study.springmvc.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.study.springmvc.entity.Supplier;
import com.study.springmvc.repository.SupplierRepository;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@GetMapping("/")
	public String index(Model model , @ModelAttribute Supplier supplier) {
		model.addAttribute("suppliers" , supplierRepository.findAll());
		model.addAttribute("_method" , "POST");
		return "supplier";
	}
	
	@GetMapping("/{id}")
	public String get(@PathVariable("id") Long id , Model model) {
		model.addAttribute("supplier" ,  supplierRepository.findById(id));
		model.addAttribute("suppliers" , supplierRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "supplier";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id , Model model) {
		model.addAttribute("supplier" ,  supplierRepository.findById(id));
		model.addAttribute("suppliers" , supplierRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "supplier-edit";
	}
	
	@PutMapping("/")
	public String update(Model model , @Valid @ModelAttribute Supplier supplier , BindingResult result , RedirectAttributesModelMap modelMap) {
		if(result.hasErrors()) {
			model.addAttribute("suppliers" , supplierRepository.findAll());
			model.addAttribute("_method" , "PUT");
			return "supplier";
		}
		   supplierRepository.save(supplier);
		   modelMap.addFlashAttribute("message" , "修改成功");
		   return "redirect:./";
	}
	
	@PutMapping("/update")
	public String updatePage(Model model , @Valid @ModelAttribute Supplier supplier , BindingResult result , RedirectAttributesModelMap modelMap) {
		if(result.hasErrors()) {
			model.addAttribute("suppliers" , supplierRepository.findAll());
			model.addAttribute("_method" , "PUT");
			return "supplier-edit";
		}
		   supplierRepository.save(supplier);
		   modelMap.addFlashAttribute("message" , "修改成功");
		   return "redirect:./";
	}
	
	@PostMapping("/")
	public String add(Model model , @Valid @ModelAttribute Supplier supplier , BindingResult result , RedirectAttributesModelMap modelMap) {
		if(result.hasErrors()) {
			model.addAttribute("suppliers" , supplierRepository.findAll());
			model.addAttribute("_method" , "POST");
			return "supplier";
		}
		   supplierRepository.save(supplier);
		   modelMap.addFlashAttribute("message" , "新增成功");
		   return "redirect:./";
	  }
	
	@GetMapping("/delete/{id}")
	public String delete(Model model , @PathVariable("id") Long id , RedirectAttributesModelMap modelMap) {
		  try {
			  supplierRepository.deleteById(id);
			  modelMap.addFlashAttribute("message" , "刪除成功");
			  return "redirect:../";
		} catch (Exception e) {
			List<Long> pid = supplierRepository.findById(id).get().getPurchases().stream().map(c->c.getId()).collect(Collectors.toList());
			model.addAttribute("supplier" , new Supplier());
			model.addAttribute("suppliers" , supplierRepository.findAll());
			model.addAttribute("_method" , "POST");
			model.addAttribute("message" , "供應商尚有訂單無法刪除(採購單:" + pid + ")");
			return "supplier";
		} 
		  
		   
	}
	
}
