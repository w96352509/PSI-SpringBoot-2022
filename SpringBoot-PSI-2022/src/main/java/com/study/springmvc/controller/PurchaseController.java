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

import com.study.springmvc.entity.Purchase;
import com.study.springmvc.entity.PurchaseItem;
import com.study.springmvc.repository.EmployeeRepository;
import com.study.springmvc.repository.ProductRepository;
import com.study.springmvc.repository.PurchaseItemRepository;
import com.study.springmvc.repository.PurchaseRepository;
import com.study.springmvc.repository.SupplierRepository;

@Controller
@RequestMapping("/purchase")
/* 採購主檔
 * --------------------------------------------------------------------
 * GET  -> /            -> index
 * GET  -> /{id}        -> get
 * GET  -> /delete/{id} -> delete
 * POST -> /            -> add
 * PUT  -> /            -> update
 ----------------------------------------------------------------------
 * 採購細目
 * --------------------------------------------------------------------
 * GET  -> /{pid}/item              -> indexItem
 * GET  -> /{pid}/item/{iid}        -> getItem
 * GET  -> /{pid}/item/delete/{iid} -> deleteItem
 * POST -> /{pid}/item              -> addItem
 * PUT  -> /{pid}/item              -> updateItem
 ---------------------------------------------------------------------*/
public class PurchaseController {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private PurchaseItemRepository purchaseItemRepository;

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute Purchase purchase) {
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("suppliers", supplierRepository.findAll());
		model.addAttribute("purchases", purchaseRepository.findAll());
		model.addAttribute("_method", "POST");
		return "purchase";
	}

	@GetMapping("/{id}")
	public String get(@PathVariable("id") Long id, Model model) {
		model.addAttribute("purchase", purchaseRepository.findById(id));
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("suppliers", supplierRepository.findAll());
		model.addAttribute("purchases", purchaseRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "purchase";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("purchase", purchaseRepository.findById(id));
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("suppliers", supplierRepository.findAll());
		model.addAttribute("purchases", purchaseRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "purchase-edit";
	}

	@PutMapping("/")
	public String update(Model model, @Valid @ModelAttribute Purchase purchase, BindingResult result,
			RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("suppliers", supplierRepository.findAll());
			model.addAttribute("purchases", purchaseRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "purchase";
		}
		purchaseRepository.save(purchase);
		modelMap.addFlashAttribute("message", "修改成功");
		return "redirect:./";
	}

	@PutMapping("/update")
	public String updatePage(Model model, @Valid @ModelAttribute Purchase purchase, BindingResult result,
			RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("suppliers", supplierRepository.findAll());
			model.addAttribute("purchases", purchaseRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "purchase-edit";
		}
		purchaseRepository.save(purchase);
		modelMap.addFlashAttribute("message", "修改成功");
		return "redirect:./";
	}

	@PostMapping("/")
	public String add(Model model, @Valid @ModelAttribute Purchase purchase, BindingResult result,
			RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("suppliers", supplierRepository.findAll());
			model.addAttribute("purchases", purchaseRepository.findAll());
			model.addAttribute("_method", "POST");
			return "purchase";
		}
		purchaseRepository.save(purchase);
		modelMap.addFlashAttribute("message", "新增成功");
		return "redirect:./";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id , Model model , RedirectAttributesModelMap modelMap ) {
		try {
			purchaseRepository.deleteById(id);
			modelMap.addFlashAttribute("message", "刪除成功");
			return "redirect:../";
		} catch (Exception e) {
			List<Long> ItemId = purchaseRepository.findById(id).get().getPurchaseItems().stream().map(c-> c.getId()).collect(Collectors.toList());
			model.addAttribute("purchase" , new Purchase());
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("suppliers", supplierRepository.findAll());
			model.addAttribute("purchases", purchaseRepository.findAll());
			model.addAttribute("_method", "POST");
			model.addAttribute("message", "此訂單尚有細目無法刪除 , 細目ID :" + ItemId +"");
			return "purchase";
		}
	}
// 明細部分------------------------------------------------------------------------------------------

	// 明細主頁
	@GetMapping("/{id}/item")
	public String itemIndex(@PathVariable("id") Long id , Model model , @ModelAttribute PurchaseItem purchaseItem) {
		model.addAttribute("purchase" , purchaseRepository.findById(id).get());
		model.addAttribute("products" , productRepository.findAll());
		model.addAttribute("_method" , "POST");
		return "purchaseItem";
	}
	
}
