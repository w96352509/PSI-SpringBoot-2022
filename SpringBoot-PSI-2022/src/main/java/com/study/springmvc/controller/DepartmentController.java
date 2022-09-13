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

import com.study.springmvc.entity.Department;
import com.study.springmvc.repository.DepartmentRepository;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/")
	public String index(Model model, @ModelAttribute Department department) {
		model.addAttribute("departments", departmentRepository.findAll());
		model.addAttribute("_method", "POST");
		return "department";
	}

	@GetMapping("/{id}")
	public String get(Model model, @PathVariable("id") Long id) {
		model.addAttribute("department", departmentRepository.findById(id));
		model.addAttribute("departments", departmentRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "department";
	}

	// 跳頁讀取
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("department", departmentRepository.findById(id));
		model.addAttribute("departments", departmentRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "department-edit";
	}

	@PostMapping("/")
	public String add(Model model , @Valid @ModelAttribute Department department , BindingResult result ,RedirectAttributesModelMap modelMap) {
		if(result.hasErrors()) {
			model.addAttribute("departments", departmentRepository.findAll());
			model.addAttribute("_method", "POST");
			return "department";
		}
		departmentRepository.save(department);
		modelMap.addFlashAttribute("resultMsg", "新增成功");
		return "redirect:./";
	}
	
	@PutMapping("/")
	public String update(Model model, @Valid @ModelAttribute Department department, BindingResult result ,RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("departments", departmentRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "department";
		}
		departmentRepository.save(department);
		modelMap.addFlashAttribute("resultMsg", "修改成功");
		return "redirect:./";
	}

	// 跳頁
	@PutMapping("/update")
	public String updatePage(Model model, @Valid @ModelAttribute Department department, BindingResult result , RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("departments", departmentRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "department-edit";
		}
		departmentRepository.save(department);
		modelMap.addFlashAttribute("resultMsg", "修改成功");
		return "redirect:./";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id , Model model , RedirectAttributesModelMap modelMap) {
		try {
			departmentRepository.deleteById(id);
			modelMap.addFlashAttribute("resultMsg", "删除成功");
			return "redirect:../";
		} catch (Exception e) {
			model.addAttribute("department" , new Department());
			model.addAttribute("departments", departmentRepository.findAll());
			model.addAttribute("_method", "POST");
			model.addAttribute("message", String.format("此%s尚有員工無法刪除",departmentRepository.findById(id).get().getName()));
			return "department";
		}
	}

}
