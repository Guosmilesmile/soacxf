package com.edu.message;
import com.edu.entity.*;
/**
 * 预存款申请消息
 * @author Gy
 *
 */
public class preDepositRequestMessage {
	private CustomerType customer;//用户
	private String myCreditCardId;//卡号
	private Double funds;//申请金额
	private String salerCreditCardId;//接受者的卡号
	private Integer orderid;
	public preDepositRequestMessage(CustomerType customer,
			String myCreditCardId, Double funds, String salerCreditCardId,
			Integer orderid) {
		super();
		this.customer = customer;
		this.myCreditCardId = myCreditCardId;
		this.funds = funds;
		this.salerCreditCardId = salerCreditCardId;
		this.orderid = orderid;
	}
	
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public preDepositRequestMessage() {
		super();
	}
	public CustomerType getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerType customer) {
		this.customer = customer;
	}
	public String getMyCreditCardId() {
		return myCreditCardId;
	}
	public void setMyCreditCardId(String myCreditCardId) {
		this.myCreditCardId = myCreditCardId;
	}
	public Double getFunds() {
		return funds;
	}
	public void setFunds(Double funds) {
		this.funds = funds;
	}
	public String getSalerCreditCardId() {
		return salerCreditCardId;
	}
	public void setSalerCreditCardId(String salerCreditCardId) {
		this.salerCreditCardId = salerCreditCardId;
	}
	
}
