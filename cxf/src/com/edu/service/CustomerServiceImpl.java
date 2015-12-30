package com.edu.service;

import java.util.List;

import javax.jws.WebService;

import com.edu.entity.OrderType;
import com.edu.entity.ProductType;
import com.edu.message.OrderAcceptedMessage;
import com.edu.message.OrderCancelledMessage;
import com.edu.message.transferFundsMessage;
import com.edu.dao.ICustomerTypeDao;
import com.edu.dao.LkProductDAO;
import com.edu.daoimpl.CustomerTypeDaoImpl;
import com.edu.daoimpl.LKProductDAOImpl;
import com.edu.dao.LkProductDAO;
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

	@Override
	public List<ProductType> getAllProduct() {
		LkProductDAO productdao = new LKProductDAOImpl();
		return productdao.getProductList();
	

	}
	
}
