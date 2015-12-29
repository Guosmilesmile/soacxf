package com.edu.message;

import com.edu.entity.OrderType;
/**
 * 订单接收消息
 * @author Gy
 *
 */
public class OrderAcceptedMessage {
	private OrderType order;
	private String salerCreditCardId;
	public OrderAcceptedMessage(OrderType order, String salerCreditCardId) {
		super();
		this.order = order;
		this.salerCreditCardId = salerCreditCardId;
	}
	public OrderAcceptedMessage() {
		super();
	}
	public OrderType getOrder() {
		return order;
	}
	public void setOrder(OrderType order) {
		this.order = order;
	}
	public String getSalerCreditCardId() {
		return salerCreditCardId;
	}
	public void setSalerCreditCardId(String salerCreditCardId) {
		this.salerCreditCardId = salerCreditCardId;
	}
}
