package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct()
	{
		return  productRepository.findAll();
	}
	
	public void addProduct(Product product)
	{
		productRepository.save(product);
	}
	
	public void removeProductId(int id)
	{
		productRepository.deleteById(id);
	}
	
	public Optional<Product> getAllProductById(int id)
	{
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProductByCategory(int id)
	{
		return productRepository.findAllByCategory_Id(id);
	}
}
