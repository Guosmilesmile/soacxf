package com.edu.message;

import com.edu.entity.OrderType;

/**
 * 取消预存款消息
 * @author Christy
 *
 */
public class cancelPreDepositMessage {
	private OrderType orderType;

	public cancelPreDepositMessage(OrderType orderType) {
		super();
		this.orderType = orderType;
	}

	public cancelPreDepositMessage() {
		super();
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
}
