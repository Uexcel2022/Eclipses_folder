package com.uexcel.model;

public class Order {
	private String productName;
	private String quantity;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [productName=" + productName + ", quantity=" + quantity + "]";
	}
	

	
	
}
