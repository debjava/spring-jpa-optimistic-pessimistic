package com.ddlab.rnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.Product;
import com.ddlab.rnd.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;

	@Transactional
	@Override
	public Product saveProduct(Product p) {
		return Optional.ofNullable(productRepo.save(p)).get();
	}

	@Transactional
	@Override
	public void saveAllProducts(List<Product> ps) {
		productRepo.saveAll(ps);
	}

	@Transactional
	@Override
	public Product getProductById(long id) {
		Product prod = null;
		Optional<Product> optProd = productRepo.findProductById(id);
		if(!optProd.isEmpty())
			prod = optProd.get();
		return prod;
	}
	
	@Transactional
	@Override
	public void updatePrice(Product p) {
		productRepo.updatePrice(p.getPrice(), p.getId());
	}
	
	@Transactional
	@Override
	public Product getProductByName(String name) {
		Product prod = null;
		Optional<Product> optProd = productRepo.getproductByName(name);
		if(!optProd.isEmpty())
			prod = optProd.get();
		return prod;
	}

}
