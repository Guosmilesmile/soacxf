package com.edu.entity;

public class BalanceType {
	private Integer id;
	private Integer customerid;
	private Integer productid;
	private Double balance;
	private Double prebalance;
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getPrebalance() {
		return prebalance;
	}
	public void setPrebalance(Double prebalance) {
		this.prebalance = prebalance;
	}
	public BalanceType(Integer id, Integer customerid, Integer productid,
			Double balance, Double prebalance) {
		super();
		this.id = id;
		this.customerid = customerid;
		this.productid = productid;
		this.balance = balance;
		this.prebalance = prebalance;
	}
	public BalanceType() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
}
