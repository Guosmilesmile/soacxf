package com.edu.service;

import javax.jws.WebService;

import com.edu.entity.OrderType;
@WebService
public interface ICustomerService {
	/**
	 * 发送订单
	 * @return
	 */
	public int CustomerSendOrder(OrderType orderType);
	
	
	public int OrderCancelledCallback();
}
