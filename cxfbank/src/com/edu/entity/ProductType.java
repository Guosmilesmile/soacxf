package com.edu.entity;

public class ProductType {
	private String name;
	private String sku;//库存量单位
	private String manufacture;
	private String cost;
	public ProductType(String name, String sku, String manufacture, String cost) {
		super();
		this.name = name;
		this.sku = sku;
		this.manufacture = manufacture;
		this.cost = cost;
	}
	public ProductType() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
}
