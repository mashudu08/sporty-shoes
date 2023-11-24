package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

}
