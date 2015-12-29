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
	public Integer getToid() {
		return toid;
	}
	public void setToid(Integer toid) {
		this.toid = toid;
	}
	public OrderType(String orderId, CustomerType customer,
			ProductType product, int amount, Date timeStamp, Integer toid) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		this.amount = amount;
		this.timeStamp = timeStamp;
		this.toid = toid;
	}
	public OrderType(String orderId, CustomerType customer,
			ProductType product, int amount, Date timeStamp) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		this.amount = amount;
		this.timeStamp = timeStamp;
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
