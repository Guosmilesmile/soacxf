package com.edu.entity;

public class OrderView {
	String orderId;
	String custommerName;
	String productName;
	String productManufacture;
	int cost;
	public OrderView(String orderId, String custommerName, String productName,
			String productManufacture, int cost) {
		super();
		this.orderId = orderId;
		this.custommerName = custommerName;
		this.productName = productName;
		this.productManufacture = productManufacture;
		this.cost = cost;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustommerName() {
		return custommerName;
	}
	public void setCustommerName(String custommerName) {
		this.custommerName = custommerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductManufacture() {
		return productManufacture;
	}
	public void setProductManufacture(String productManufacture) {
		this.productManufacture = productManufacture;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
