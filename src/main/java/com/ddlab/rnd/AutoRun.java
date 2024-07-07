package com.ddlab.rnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.Item;
import com.ddlab.rnd.entity.Product;
import com.ddlab.rnd.service.ItemService;
import com.ddlab.rnd.service.ProductService;

@Component
public class AutoRun {

	@Autowired
	private ProductService prodService;

	@Autowired
	private ItemService itemService;

	private void saveProducts() {
		List<Product> prodList = List.of(new Product("Samsung", 2000), new Product("Nokia", 3000),
				new Product("HTC Mobile", 4000));
		prodService.saveAllProducts(prodList);
	}

	public Product getProductById(long productId) {
		Product prod = prodService.getProductById(productId);
		System.out.println("Product Details: " + prod);
		return prod;
	}

	public void getProductByName(String name) {
		Product prod = prodService.getProductByName(name);
		System.out.println("Product Details with name: " + prod);
	}

	public void checkForOptimistic() {
//		saveProducts();
		// Get product by id and no need to increment version
//		Product prod = getProductById(102);
//		prod.setPrice(6000);
//		prodService.updatePrice(prod);
//		System.out.println("Get the updated product again ...");
//		getProductById(102);

		// Get product by name and increment version
//		getProductByName("Nokia");
	}

	public void checkForPessimistic() {
		List<Item> items = List.of(new Item("Mobile", 3, 3000), new Item("Office NoteBook", 4, 1000),
				new Item("Electric Bike", 2, 27000), new Item("Medicine", 5, 100), new Item("Cooktop", 1, 2000),
				new Item("Grocery", 5, 1000));
		itemService.saveAllItems(items);
		
		// Only for reading, office notebook
		Item item1 = itemService.getItemById(Long.valueOf(103));
		System.out.println("Item1 details: "+item1);
		
		// Only for writing price, do not update version for cooktop
		itemService.updateItemPrice(106, 3000);
		// Get the updated item price
		Item item2 = itemService.getItemById(Long.valueOf(106));
		System.out.println("Item2 details: "+item2);
//		
//		//Based upon mobile usage, rating is updated for mobile
		itemService.updateItemRating("Mobile",5);
		Item item3 = itemService.getItemById(Long.valueOf(102));
		System.out.println("Item3 details: "+item3);
		
		// Check for Medicine
		Item item5 = itemService.getItemById(Long.valueOf(105));
		System.out.println("Item1 details: "+item5);
		
		itemService.setItemRating("Mobile",4);
		Item item7 = itemService.getItemById(Long.valueOf(102));
		System.out.println("Item3 details: "+item7);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void checkAndRun() {
		System.out.println("Application Stated Running ....");
		
		checkForPessimistic();

	}

}
