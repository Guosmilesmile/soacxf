package com.edu.message;

import com.edu.entity.CustomerType;
import com.edu.entity.OrderType;

public class newOrderMessage {
	private CustomerType customerType;
	private OrderType orderType;
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	public newOrderMessage(CustomerType customerType, OrderType orderType) {
		super();
		this.customerType = customerType;
		this.orderType = orderType;
	}
	public newOrderMessage() {
		super();
	}
	
}
