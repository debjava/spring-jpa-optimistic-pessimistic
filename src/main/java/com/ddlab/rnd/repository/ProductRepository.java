package com.ddlab.rnd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Product;

import jakarta.persistence.LockModeType;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Lock(LockModeType.OPTIMISTIC)
	Optional<Product> findProductById(Long Id);
	
	//Useful to find popular product
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	@Query("select p from Product p where p.name=:name")
	Optional<Product> getproductByName(@Param("name") String name);
	
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	@Query("select p from Product p where p.name=:name")
	Optional<Product> searchProductByName(@Param("name") String name);
	
	@Modifying
	@Query("update Product p set p.price = :price where p.id = :id")
	void updatePrice(@Param("price") int price, @Param("id") long id);

}
