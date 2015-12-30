package com.edu.service;

import java.util.List;

import javax.jws.WebService;

import com.edu.entity.OrderType;
import com.edu.entity.ProductType;
import com.edu.message.OrderAcceptedMessage;
import com.edu.message.OrderCancelledMessage;
import com.edu.message.transferFundsMessage;
@WebService
public interface ICustomerService {
	
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
	/**
	 * 获取所有的商品
	 */
	public List<ProductType> getAllProduct();
}
