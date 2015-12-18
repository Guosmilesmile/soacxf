package com.edu.entity;

public class preDepositRequestMessage {
	private CustomerType customer;
	private String myCreditCardId;
	private Double funds;
	private String salerCreditCardId;
	public preDepositRequestMessage(CustomerType customer,
			String myCreditCardId, Double funds, String salerCreditCardId) {
		super();
		this.customer = customer;
		this.myCreditCardId = myCreditCardId;
		this.funds = funds;
		this.salerCreditCardId = salerCreditCardId;
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
