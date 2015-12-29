package com.edu.message;

import com.edu.entity.OrderType;

/**
 * 订单取消消息
 * @author Gy
 *
 */
public class OrderCancelledMessage {
	private OrderType order;
	private String reason;
	public OrderCancelledMessage(OrderType order, String reason) {
		super();
		this.order = order;
		this.reason = reason;
	}
	public OrderCancelledMessage() {
		super();
	}
	public OrderType getOrder() {
		return order;
	}
	public void setOrder(OrderType order) {
		this.order = order;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
