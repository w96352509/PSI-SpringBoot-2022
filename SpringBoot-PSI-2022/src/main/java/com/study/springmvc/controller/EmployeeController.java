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
import com.study.springmvc.entity.Employee;
import com.study.springmvc.repository.DepartmentRepository;
import com.study.springmvc.repository.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute Employee employee) {
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("departments", departmentRepository.findAll());
		model.addAttribute("_method", "POST");
		return "employee";
	}

	@GetMapping("/{id}")
	public String get(Model model, @PathVariable("id") Long id) {
		model.addAttribute("employee", employeeRepository.findById(id));
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("departments", departmentRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "employee";
	}

	// 跳頁讀取
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("employee", employeeRepository.findById(id));
		model.addAttribute("departments", departmentRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "employee-edit";
	}

	@PostMapping("/")
	public String add(Model model , @Valid @ModelAttribute Employee employee , BindingResult result ,RedirectAttributesModelMap modelMap) {
		if(result.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("departments", departmentRepository.findAll());
			model.addAttribute("_method", "POST");
			return "employee";
		}
		employeeRepository.save(employee);
		modelMap.addFlashAttribute("resultMsg", "新增成功");
		return "redirect:./";
	}
	
	@PutMapping("/")
	public String update(Model model, @Valid @ModelAttribute Employee employee, BindingResult result ,RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("departments", departmentRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "employee";
		}
		employeeRepository.save(employee);
		modelMap.addFlashAttribute("resultMsg", "修改成功");
		return "redirect:./";
	}

	// 跳頁
	@PutMapping("/update")
	public String updatePage(Model model, @Valid @ModelAttribute Employee employee, BindingResult result ,RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("departments", departmentRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "employee-edit";
		}
		employeeRepository.save(employee);
		modelMap.addFlashAttribute("resultMsg", "修改成功");
		return "redirect:./";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id , Model model , RedirectAttributesModelMap modelMap) {
		try {
			employeeRepository.deleteById(id);
			modelMap.addFlashAttribute("resultMsg", "删除成功");
			return "redirect:../";
		} catch (Exception e) {
			model.addAttribute("employee" , new Employee());
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("departments", departmentRepository.findAll());
			model.addAttribute("_method", "POST");
			model.addAttribute("message", "刪除失敗");
			return "employee";
		}
	}

}
