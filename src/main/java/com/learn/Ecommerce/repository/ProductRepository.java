package com.learn.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
//http://localhost:8080/products/search/findByProductPriceLessThan?price=50000
	
	List<Product>findByProductPriceLessThan(int price);

//http://localhost:8080/products/search/findByProductPriceGreaterThan?price=50000	
	
	List<Product>findByProductPriceGreaterThan(int price);
	
//http://localhost:8080/products/search/findByProductPriceLessThanEqual?price=50000
	
	List<Product>findByProductPriceLessThanEqual(int price);
	
//http://localhost:8080/products/search/findByProductPriceBetween?startPrice=15000&endPrice=65000	
	
	List<Product>findByProductPriceBetween(int startPrice,int endPrice);
	
	
	List<Product> findByProductNameStartingWith(String productName);
}
