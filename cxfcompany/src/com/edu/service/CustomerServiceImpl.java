package com.edu.service;

import javax.jws.WebService;

import com.edu.entity.OrderType;
import com.edu.message.OrderAcceptedMessage;
import com.edu.message.OrderCancelledMessage;
import com.edu.message.transferFundsMessage;

@WebService(endpointInterface = "com.edu.service.ICustomerService")
public class CustomerServiceImpl implements ICustomerService{

	@Override
	public int CustomerOrderCancelledCallback(
			OrderCancelledMessage orderCancelledMessage) {
		return 0;
	}

	@Override
	public int CustomerOrderAcceptedCallback(
			OrderAcceptedMessage orderAcceptedMessage) {
		return 0;
	}

	@Override
	public int CustomerTransferCompleteCallback(
			transferFundsMessage transferFundsMessage) {
		return 0;
	}
	
}
