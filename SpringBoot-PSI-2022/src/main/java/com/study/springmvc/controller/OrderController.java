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

import com.study.springmvc.entity.Order;
import com.study.springmvc.entity.OrderItem;
import com.study.springmvc.repository.CustomerRepository;
import com.study.springmvc.repository.ProductRepository;
import com.study.springmvc.validator.InventoryValidator;
import com.study.springmvc.repository.OrderRepository;
import com.study.springmvc.repository.OrderItemRepository;
import com.study.springmvc.repository.EmployeeRepository;


@Controller
@RequestMapping("/order")
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
public class OrderController {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private InventoryValidator inventoryValidator;
	
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute Order order) {
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("orders", orderRepository.findAll());
		model.addAttribute("_method", "POST");
		return "order";
	}

	@GetMapping("/{id}")
	public String get(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order", orderRepository.findById(id));
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("orders", orderRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "order";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order", orderRepository.findById(id));
		model.addAttribute("employees", employeeRepository.findAll());
		model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("orders", orderRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "order-edit";
	}

	@PutMapping("/")
	public String update(Model model, @Valid @ModelAttribute Order order, BindingResult result,
			RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("customers", customerRepository.findAll());
			model.addAttribute("orders", orderRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "order";
		}
		orderRepository.save(order);
		modelMap.addFlashAttribute("message", "修改成功");
		return "redirect:./";
	}

	@PutMapping("/update")
	public String updatePage(Model model, @Valid @ModelAttribute Order order, BindingResult result,
			RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("customers", customerRepository.findAll());
			model.addAttribute("orders", orderRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "order-edit";
		}
		orderRepository.save(order);
		modelMap.addFlashAttribute("message", "修改成功");
		return "redirect:./";
	}

	@PostMapping("/")
	public String add(Model model, @Valid @ModelAttribute Order order, BindingResult result,
			RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("customers", customerRepository.findAll());
			model.addAttribute("orders", orderRepository.findAll());
			model.addAttribute("_method", "POST");
			return "order";
		}
		orderRepository.save(order);
		modelMap.addFlashAttribute("message", "新增成功");
		return "redirect:./";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id , Model model , RedirectAttributesModelMap modelMap ) {
		try {
			orderRepository.deleteById(id);
			modelMap.addFlashAttribute("message", "刪除成功");
			return "redirect:../";
		} catch (Exception e) {
			List<Long> ItemId = orderRepository.findById(id).get().getOrderItems().stream().map(c-> c.getId()).collect(Collectors.toList());
			model.addAttribute("order" , new Order());
			model.addAttribute("employees", employeeRepository.findAll());
			model.addAttribute("customers", customerRepository.findAll());
			model.addAttribute("orders", orderRepository.findAll());
			model.addAttribute("_method", "POST");
			model.addAttribute("message", "此訂單尚有細目無法刪除 , 細目ID :" + ItemId +"");
			return "order";
		}
	}
// 明細部分------------------------------------------------------------------------------------------

	// 明細主頁
		@GetMapping("/{oid}/item")
		public String itemIndex(@PathVariable("oid") Long oid , Model model , @ModelAttribute OrderItem orderItem) {
			Order order = orderRepository.findById(oid).get();
			model.addAttribute("order" , order);
			model.addAttribute("products" , productRepository.findAll());
			model.addAttribute("_method" , "POST");
			return "orderItem";
		}
		
		@PostMapping("/{oid}/item")
		public String addItem(@Valid @ModelAttribute OrderItem orderItem, @PathVariable("oid") long oid, BindingResult result, Model model)  {
			inventoryValidator.validate(orderItem, result);
			if(result.hasErrors()) {
				model.addAttribute("order", orderRepository.findById(oid).get());
				model.addAttribute("products", productRepository.findAll());
				model.addAttribute("_method", "POST");
				return "orderitem";
			}
			orderItemRepository.save(orderItem);
			return "redirect:./item";
		}
		
		@GetMapping("/{oid}/item/{iid}")
		public String get(@PathVariable("oid") Long oid , @PathVariable("iid") Long iid , Model model) {
			model.addAttribute("orderItem" , orderItemRepository.findById(iid).get());
			model.addAttribute("order" , orderRepository.findById(oid).get());
			model.addAttribute("products" , productRepository.findAll());
			model.addAttribute("_method" , "PUT");
			return "orderItem";
		}
		
		@PutMapping("/{oid}/item")
		public String update(@PathVariable("oid") Long oid , Model model , @ModelAttribute OrderItem orderItem , RedirectAttributesModelMap modelMap) {
			orderItemRepository.save(orderItem);
			modelMap.addFlashAttribute("message" , "修改成功");
			return "redirect:./item";
		}
		
		@GetMapping("/{oid}/item/delete/{iid}")
		public String delete(@PathVariable("oid") Long oid , @PathVariable("iid") Long iid , RedirectAttributesModelMap modelMap) {
			orderItemRepository.deleteById(iid);
			modelMap.addFlashAttribute("message" , "刪除成功");
			return "redirect:../";
		}
	
}
