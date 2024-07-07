package com.ddlab.rnd.service;

import java.util.List;

import com.ddlab.rnd.entity.Item;

public interface ItemService {
	
	Item getItemById(Long id);
	
	Item saveItem(Item item);
	
	void saveAllItems(List<? extends Item> items);
	
	void updateItemPrice(long id, int price);
	
	void updateItemRating(String name, int rating);
	
	void setItemRating(String name, int rating);

}
