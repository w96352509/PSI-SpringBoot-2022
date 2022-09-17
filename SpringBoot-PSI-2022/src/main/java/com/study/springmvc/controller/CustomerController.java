package com.study.springmvc.controller;

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

import com.study.springmvc.entity.Customer;
import com.study.springmvc.entity.Supplier;
import com.study.springmvc.repository.CustomerRepository;
import com.study.springmvc.repository.SupplierRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/")
	public String index(Model model , @ModelAttribute Customer customer) {
		model.addAttribute("customers" , customerRepository.findAll());
		model.addAttribute("_method" , "POST");
		return "customer";
	}
	
	@GetMapping("/{id}")
	public String get(@PathVariable("id") Long id , Model model) {
		model.addAttribute("customer" ,  customerRepository.findById(id));
		model.addAttribute("customers" , customerRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "customer";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id , Model model) {
		model.addAttribute("customer" ,  customerRepository.findById(id));
		model.addAttribute("customers" , customerRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "customer-edit";
	}
	
	@PutMapping("/")
	public String update(Model model , @Valid @ModelAttribute Customer customer , BindingResult result , RedirectAttributesModelMap modelMap) {
		if(result.hasErrors()) {
			model.addAttribute("suppliers" , customerRepository.findAll());
			model.addAttribute("_method" , "PUT");
			return "customer";
		}
		   customerRepository.save(customer);
		   modelMap.addFlashAttribute("message" , "修改成功");
		   return "redirect:./";
	}
	
	@PutMapping("/update")
	public String updatePage(Model model , @Valid @ModelAttribute Customer customer , BindingResult result , RedirectAttributesModelMap modelMap) {
		if(result.hasErrors()) {
			model.addAttribute("suppliers" , customerRepository.findAll());
			model.addAttribute("_method" , "PUT");
			return "customer-edit";
		}
		   customerRepository.save(customer);
		   modelMap.addFlashAttribute("message" , "修改成功");
		   return "redirect:./";
	}
	
	@PostMapping("/")
	public String add(Model model , @Valid @ModelAttribute Customer customer , BindingResult result , RedirectAttributesModelMap modelMap) {
		if(result.hasErrors()) {
			model.addAttribute("suppliers" , customerRepository.findAll());
			model.addAttribute("_method" , "POST");
			return "customer";
		}
		   customerRepository.save(customer);
		   modelMap.addFlashAttribute("message" , "新增成功");
		   return "redirect:./";
	  }
	
	@GetMapping("/delete/{id}")
	public String delete( Model model ,@PathVariable("id") Long id , RedirectAttributesModelMap modelMap) {
		   try {
			   customerRepository.deleteById(id);
			   modelMap.addFlashAttribute("message" , "刪除成功");
			   return "redirect:../";
		} catch (Exception e) {
			model.addAttribute("customer" ,  new Customer());
			model.addAttribute("customers" , customerRepository.findAll());
			model.addAttribute("_method" , "PUT");
			model.addAttribute("message" , "客戶尚有訂單無法刪除");
			return "customer";
		}   
		  
	}
	
}
