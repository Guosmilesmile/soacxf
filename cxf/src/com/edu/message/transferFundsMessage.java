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
	public Double getFunds() {
		return funds;
	}

	public void setFunds(Double funds) {
		this.funds = funds;
	}

	public transferFundsMessage(CustomerType customerType,
			CustomerType receiverCustomerType, Double funds) {
		super();
		this.customerType = customerType;
		this.receiverCustomerType = receiverCustomerType;
		this.funds = funds;
	}

	private Double funds;

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
	};
	
}
