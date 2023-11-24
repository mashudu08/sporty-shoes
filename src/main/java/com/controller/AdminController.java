package com.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dto.ProductDTO;
import com.model.Product;
import com.model.ProductCategory;
import com.service.ProductCategoryService;
import com.service.ProductService;

@Controller
public class AdminController {
	
	public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";
	
	@Autowired
	ProductCategoryService prodCatService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/admin")
	public String adminHome()
	{
		return "adminHome";
	}
	
	// <------------ Product Category -------------->
	
	// Request to get all product categories
	@GetMapping("/admin/categories")
	public String getProdCategories(Model model)
	{
		model.addAttribute("categories", prodCatService.getAllCategories());
		return "categories";
	}
	
	// Request to get added category
	@GetMapping("/admin/categories/add")
	public String getAddCategory(Model model) {
		
		model.addAttribute("category", new ProductCategory());
		return "categoriesAdd";
	}
	
	// Add a category
	@PostMapping("/admin/categories/add")
	public String postCategoryAdd(@ModelAttribute("category") ProductCategory category)
	{
		prodCatService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	// Delete category
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id)
	{
		prodCatService.removeCategories(id);
		return "redirect:/admin/categories";
	}
	
	//Update category
	@GetMapping("/admin/categories/update/{id}")
	public String updateCategoy(@PathVariable int id, Model model)
	{
		Optional<ProductCategory> category = prodCatService.getCategoryById(id);
		if(category.isPresent())
		{
			model.addAttribute("category", category.get());
			return "categoriesAdd";
		}
		else
		{
			return "404";
		}
	}
	
	// <--------- Product ----------->
	
	//Get/view all products
	@GetMapping("/admin/products")
	public String products(Model model)
	{
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}
	
	// Get added product
	@GetMapping("/admin/products/add")
	public String productAdd(Model model)
	{
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", prodCatService.getAllCategories());
		return "productsAdd";
		
	}
	
	@PostMapping("/admin/products/add")
	public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO,
								@RequestParam("productImage") MultipartFile file,
								@RequestParam("imgName") String imgName) throws IOException
		{
			Product product = new Product();
			product.setId(productDTO.getId());
			product.setName(productDTO.getName());
			product.setCategory(prodCatService.getCategoryById(productDTO.getCategoryId()).get());
			product.setPrice(productDTO.getPrice());
			product.setWeight(productDTO.getWeight());
			product.setDescription(productDTO.getDescription());
			
			String imageUUID;
			if(!file.isEmpty())
			{
				imageUUID = file.getOriginalFilename();
				Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
				Files.write(fileNameAndPath, file.getBytes());
			}
			else
			{
				imageUUID = imgName;
			}
			
			product.setImageName(imageUUID);
			productService.addProduct(product);
			
			return "redirect:/admin/products";
		}
	
	// delete product
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		productService.removeProductId(id);
		return "redirect:/admin/products";
	}
	
	//Update product
	
	@GetMapping("/admin/product/update/{id}")
	public String updateProductGet(@PathVariable int id, Model model)
	{
Optional<Product> optionalProduct = productService.getAllProductById(id);
		
		if(optionalProduct.isPresent()) {
		Product product = optionalProduct.get();	
			
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setPrice(product.getPrice());
		productDTO.setWeight(product.getWeight());
		productDTO.setDescription(product.getDescription());
		productDTO.setImageName(product.getImageName());
		
		
		model.addAttribute("categories", prodCatService.getAllCategories());
		model.addAttribute("productDTO", productDTO);
		
		return "productsAdd";
		}
		else {
			return "404";
		}
	}
	
}
