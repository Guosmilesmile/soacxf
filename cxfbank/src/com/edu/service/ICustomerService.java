package com.edu.service;

import javax.jws.WebService;

import com.edu.entity.OrderType;
import com.edu.message.OrderAcceptedMessage;
import com.edu.message.OrderCancelledMessage;
import com.edu.message.transferFundsMessage;
@WebService
public interface ICustomerService {
	/**
	 * 发送订单
	 * @return
	 */
	public int CustomerSendOrder(OrderType orderType);
	
	/**
	 * 订单取消回调操作
	 * @param orderCancelledMessage
	 * @return
	 */
	public int CustomerOrderCancelledCallback(OrderCancelledMessage orderCancelledMessage);
	
	/**
	 * 订单接收回调操作
	 * @param orderAcceptedMessage
	 * @return
	 */
	public int CustomerOrderAcceptedCallback(OrderAcceptedMessage orderAcceptedMessage);
	
	/**
	 * 转账完成回调操作
	 * @param transferFundsMessage
	 * @return
	 */
	public int CustomerTransferCompleteCallback(transferFundsMessage transferFundsMessage );
}
