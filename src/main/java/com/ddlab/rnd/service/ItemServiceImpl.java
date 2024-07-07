package com.ddlab.rnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.Item;
import com.ddlab.rnd.repository.ItemRepository;

import jakarta.transaction.Transactional;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepo;

	@Transactional
	@Override
	public Item getItemById(Long id) {
		return itemRepo.findItemForRead(id);
	}

	@Transactional
	@Override
	public Item saveItem(Item item) {
		return itemRepo.save(item);
	}

	@Transactional
	@Override
	public void saveAllItems(List<? extends Item> items) {
		itemRepo.saveAll(items);
	}

	@Transactional
	@Override
	public void updateItemPrice(long id, int price) {
		Item item = itemRepo.findItemForWrite(id);
		item.setPrice(price);
		itemRepo.save(item);
	}

	@Transactional
	@Override
	public void updateItemRating(String name, int rating) {
		//It will update automatically
		itemRepo.updateItemForRating(name);
	}
	
	@Transactional
	@Override
	public void setItemRating(String name, int rating) {
		Item item = itemRepo.setRatingForItem(name);
		System.out.println("Now Mobile Item: "+item);
		
	}
	

}
