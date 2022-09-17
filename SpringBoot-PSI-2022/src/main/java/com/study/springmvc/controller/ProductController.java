package com.study.springmvc.controller;

import java.io.IOException;
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

import com.study.springmvc.entity.Product;
import com.study.springmvc.repository.ProductRepository;
import com.study.springmvc.service.LineNotify;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private LineNotify lineNotify;

	@GetMapping("/")
	public String index(Model model, @ModelAttribute Product product) {
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("_method", "POST");
		return "product";
	}

	@GetMapping("/{id}")
	public String get(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productRepository.findById(id));
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "product";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productRepository.findById(id));
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("_method", "PUT");
		return "product-edit";
	}

	@PutMapping("/")
	public String update(Model model, @Valid @ModelAttribute Product product, BindingResult result,
			RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("products", productRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "product";
		}
		productRepository.save(product);
		modelMap.addFlashAttribute("message", "修改成功");
		return "redirect:./";
	}

	@PutMapping("/update")
	public String updatePage(Model model, @Valid @ModelAttribute Product product, BindingResult result,
			RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("products", productRepository.findAll());
			model.addAttribute("_method", "PUT");
			return "product-edit";
		}
		productRepository.save(product);
		modelMap.addFlashAttribute("message", "修改成功");
		return "redirect:./";
	}

	@PostMapping("/")
	public String add(Model model, @Valid @ModelAttribute Product product, BindingResult result,
			RedirectAttributesModelMap modelMap) {
		if (result.hasErrors()) {
			model.addAttribute("products", productRepository.findAll());
			model.addAttribute("_method", "POST");
			return "product";
		}
		productRepository.save(product);
		modelMap.addFlashAttribute("message", "新增成功");
		return "redirect:./";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id, RedirectAttributesModelMap modelMap) {
		try {
			productRepository.deleteById(id);
			return "redirect:../";
		} catch (Exception e) {
			List<Long> pid = productRepository.findById(id).get().getPurchaseItems().stream()
					.map(c -> c.getPurchase().getId()).collect(Collectors.toList());
			model.addAttribute("product", new Product());
			model.addAttribute("products", productRepository.findAll());
			model.addAttribute("_method", "POST");
			model.addAttribute("message", "此商品尚有定單ID :" + pid);
			return "product";
		}

	}

	@GetMapping("/line/{id}")
	public String line(@PathVariable("id") Long id , RedirectAttributesModelMap modelMap) throws IOException {
		try {
			String supllier = null;
			String fileName = null;
			Product product = productRepository.findById(id).get();
			List<String> supName = productRepository.findById(id).get().getPurchaseItems().stream()
					.map(c -> c.getPurchase().getSupplier().getName()).collect(Collectors.toList());
			for (String s : supName) {
				supllier = s;
				fileName = supllier + product.getName() + ".jpg";
			}
			lineNotify.sendImage(product, fileName);
			return "redirect:../";
		} catch (Exception e) {
			Product product = productRepository.findById(id).get();
			lineNotify.send(product);
			modelMap.addFlashAttribute("message", "資料庫無圖片僅傳送訊息");
			return "redirect:../";
		}

	}

}
