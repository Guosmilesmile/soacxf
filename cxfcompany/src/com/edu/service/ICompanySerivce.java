package com.edu.service;

import com.edu.message.newOrderMessage;
import com.edu.message.preDepositSuccessMessage;
import com.edu.message.prepareDeliverableResultMessage;

public interface ICompanySerivce {
	/**
	 * 下订单操作
	 * @return
	 */
	public int placeOrder(newOrderMessage newOrderMessage);
	/**
	 * 预存款回调操作
	 * @param preDepositSuccessMessage
	 * @return
	 */
	public int preDepositCallback(preDepositSuccessMessage preDepositSuccessMessage);
	
	
	
}
