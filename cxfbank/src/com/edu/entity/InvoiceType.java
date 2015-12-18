package com.edu.entity;

import java.util.Date;
/**
 * 发票类型
 * @author Gy
 *
 */
public class InvoiceType {
	private String invoiceId;
	private String customername;
	private String productname;
	private String amount;
	private String productcost;
	private Date timeStamp;
	public InvoiceType(String invoiceId, String customername,
			String productname, String amount, String productcost,
			Date timeStamp) {
		super();
		this.invoiceId = invoiceId;
		this.customername = customername;
		this.productname = productname;
		this.amount = amount;
		this.productcost = productcost;
		this.timeStamp = timeStamp;
	}
	public InvoiceType() {
		super();
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getProductcost() {
		return productcost;
	}
	public void setProductcost(String productcost) {
		this.productcost = productcost;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
