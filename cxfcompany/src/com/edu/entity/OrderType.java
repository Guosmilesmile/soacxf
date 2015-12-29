package com.edu.entity;

import java.util.Date;

/**
 * 订单
 * @author Gy
 *
 */
public class OrderType {
	private String orderId;
	private CustomerType customer;
	private ProductType product;
	private int amount;
	private Date timeStamp;
	private Integer toid;
	private Integer ispay;
	private double money;
	public Integer getIspay() {
		return ispay;
	}
	public void setIspay(Integer ispay) {
		this.ispay = ispay;
	}
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public OrderType(String orderId, CustomerType customer,
			ProductType product, int amount, Date timeStamp, Integer toid,
			Integer ispay, double money) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		this.amount = amount;
		this.timeStamp = timeStamp;
		this.toid = toid;
		this.ispay = ispay;
		this.money = money;
	}
	public Integer getToid() {
		return toid;
	}
	public void setToid(Integer toid) {
		this.toid = toid;
	}
	
	
	public OrderType() {
		super();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public CustomerType getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerType customer) {
		this.customer = customer;
	}
	public ProductType getProduct() {
		return product;
	}
	public void setProduct(ProductType product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
