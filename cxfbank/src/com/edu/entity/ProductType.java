package com.edu.entity;

public class ProductType {
	private Integer id;
	private String name;
	private String sku;//库存量单位
	private String manufacture;
	private Double cost;//价位
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductType(Integer id, String name, String sku, String manufacture,
			Double cost) {
		super();
		this.id = id;
		this.name = name;
		this.sku = sku;
		this.manufacture = manufacture;
		this.cost = cost;
	}
	public ProductType(String name, String sku, String manufacture, Double cost) {
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
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
}
