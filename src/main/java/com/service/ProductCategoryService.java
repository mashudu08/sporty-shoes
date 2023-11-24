package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ProductCategory;
import com.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {
	
	@Autowired
	ProductCategoryRepository pCategoryRepository;
	
	// List all categories
	public List<ProductCategory> getAllCategories()
	{
		return pCategoryRepository.findAll();
	}
	
	// Add new category
	public void addCategory(ProductCategory category)
	{
		pCategoryRepository.save(category);
	}
	
	// Delete categories
	public void removeCategories(int id)
	{
		pCategoryRepository.deleteById(id);
	}
	
	// List a specific category
	public Optional<ProductCategory> getCategoryById(int id)
	{
		return pCategoryRepository.findById(id);
	}
}
