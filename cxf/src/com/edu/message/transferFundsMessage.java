package com.edu.message;

import com.edu.entity.CustomerType;
/**
 * 转账信息
 * @author Christy
 *
 */
public class transferFundsMessage {
	private CustomerType customerType;
	private CustomerType receiverCustomerType;
	private Integer orderid;
	private Double funds;
	
	public Double getFunds() {
		return funds;
	}

	public void setFunds(Double funds) {
		this.funds = funds;
	}

	public CustomerType getReceiverCustomerType() {
		return receiverCustomerType;
	}

	public void setReceiverCustomerType(CustomerType receiverCustomerType) {
		this.receiverCustomerType = receiverCustomerType;
	}

	public transferFundsMessage(CustomerType customerType,
			CustomerType receiverCustomerType) {
		super();
		this.customerType = customerType;
		this.receiverCustomerType = receiverCustomerType;
	}

	public transferFundsMessage(CustomerType customerType) {
		super();
		this.customerType = customerType;
	}

	public transferFundsMessage() {
		super();
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public transferFundsMessage(CustomerType customerType,
			CustomerType receiverCustomerType, Integer orderid, Double funds) {
		super();
		this.customerType = customerType;
		this.receiverCustomerType = receiverCustomerType;
		this.orderid = orderid;
		this.funds = funds;
	};
	
}
