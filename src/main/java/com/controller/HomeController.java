package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.global.GlobalData;
import com.model.Product;
import com.service.ProductCategoryService;
import com.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductCategoryService prodCatService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/home")
	public String home(Model model)
	{
		return "index";
	}
	
	// View products
	@GetMapping("/shop")
	public String shop(Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("categories", prodCatService.getAllCategories());
		model.addAttribute("products", productService.getAllProduct());
		return "shop";
	}
	
	// View product by category
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(@PathVariable int id, Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("categories", prodCatService.getAllCategories());
		model.addAttribute("products", productService.getAllProductByCategory(id));
		return "shop";
	}
	
	// View a product
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(@PathVariable int id, Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("product", productService.getAllProductById(id));
		return "viewProduct";
	}
	
	// remove product from cart
	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index)
	{
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model)
	{
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		return "checkout";
	}
	
	@GetMapping("/payNow")
	public String paymentDone()
	{
		return "paymentDone";
	}
}
