package com.edu.service;

import javax.jws.WebService;

import com.edu.entity.OrderType;

@WebService
public interface ICustomerService {
	/**
	 * 订单取消
	 * @param order
	 * @param reason
	 * @return
	 */
	public int OrderCancelledMessage(OrderType order,String reason);
	
	/**
	 * 订单接收
	 * @param order
	 * @param salerCreditCardId
	 * @return
	 */
	public int OrderAcceptedMessage(OrderType order,String salerCreditCardId);
	
	public int DeliveryStorage();
}
