package com.food.DTO;


public class CartItem {
	
    private String item;
    private double price;
    
    
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CartItem(String item, double price) {
		super();
		this.item = item;
		this.price = price;
	}
	public CartItem() {
		super();
	}

    // Getters and Setters
	
	
}
