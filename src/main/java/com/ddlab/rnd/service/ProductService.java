package com.ddlab.rnd.service;

import java.util.List;

import com.ddlab.rnd.entity.Product;

public interface ProductService {
	
	Product saveProduct(Product p);
	
	void saveAllProducts(List<Product> ps);
	
	Product getProductById(long id);
	
	void updatePrice(Product p);
	
	Product getProductByName(String name);

}
