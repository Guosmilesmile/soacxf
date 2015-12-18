package com.edu.service;

import javax.jws.WebService;

import com.edu.entity.OrderType;

public interface ICustomerService {
	/**
	 * 发送订单
	 * @return
	 */
	public int CustomerSendOrder(OrderType orderType);
	
	/**
	 * 发送预存款申请
	 * @return
	 */
	public int CustomerSendPreDeposit(int money);
	
	/**
	 * 
	 * @param money
	 * @return
	 */
	public int CustomerSendDeposit(int money);
}
