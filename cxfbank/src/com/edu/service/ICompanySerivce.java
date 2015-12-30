package com.edu.service;

import javax.jws.WebService;

import com.edu.message.newOrderMessage;

@WebService
public interface ICompanySerivce {
	/**
	 * 下订单操作
	 * @return
	 */
	public int placeOrder(newOrderMessage newOrderMessage);
	/**
	 * 转账
	 * @param preDepositSuccessMessage
	 * @return
	 */
	public int preTransCallback(Integer orderid);
	
	
	
}
