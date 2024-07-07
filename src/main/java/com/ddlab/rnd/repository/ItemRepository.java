package com.ddlab.rnd.repository;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Item;

import jakarta.persistence.LockModeType;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	
	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select i from Item i where i.id = :id")
	Item findItemForRead(@Param("id") Long id);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select i from Item i where i.id = :id")
	Item findItemForWrite(@Param("id") Long id);
	
	@Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
	@Query("select i from Item i where i.name = :name")
	Item updateItemForRating(@Param("name") String name);
	
	@Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
	@Query("select i from Item i where i.name = :name")
	Item setRatingForItem(@Param("name") String name);

}
