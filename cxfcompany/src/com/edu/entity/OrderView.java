package com.edu.entity;

public class OrderView {
	String orderId;
	String custommerName;
	String productName;
	String productManufacture;
	int productNum;
	double cost;
	public OrderView(String orderId, String custommerName, String productName,
			String productManufacture, int productNum, double cost) {
		super();
		this.orderId = orderId;
		this.custommerName = custommerName;
		this.productName = productName;
		this.productManufacture = productManufacture;
		this.productNum = productNum;
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
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}