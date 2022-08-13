package com.wishnoo.inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

	List<Product> soldProductList = new ArrayList<Product>();
	List<Product> purchasedProductList = new ArrayList<Product>();
	
	public void populateSoldProducts() {
		for(int i= 0; i < 1000; i++) {
			Product prod = new Product(i, "test_product_" + i);
			soldProductList.add(prod);
			System.out.println("ADDED: " + prod);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void displaySoldProducts() {
		for(Product product: soldProductList) {
			System.out.println("PRINTING THE SOLD: " + product);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
