package com.edu.message;

import com.edu.entity.CustomerType;
/**
 * 转账信息
 * @author Christy
 *
 */
public class transferFundsMessage {
	private CustomerType customerType;

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
