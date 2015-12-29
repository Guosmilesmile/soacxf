package com.edu.service;

import java.util.Date;

import javax.jws.WebService;

import com.edu.dao.IOrderDao;
import com.edu.dao.IProductDao;
import com.edu.daoimpl.OrderDaoImpl;
import com.edu.daoimpl.ProductTypeDaoImpl;
import com.edu.entity.OrderType;
import com.edu.entity.ProductType;
import com.edu.message.newOrderMessage;
import com.edu.message.preDepositSuccessMessage;
@WebService(endpointInterface = "com.edu.service.ICompanySerivce")
public class CompanyServiceImpl implements ICompanySerivce{
	IProductDao productDao = new ProductTypeDaoImpl();
	IOrderDao orderDao = new OrderDaoImpl();
	@Override
	public int placeOrder(newOrderMessage newOrderMessage) {
		//查看库存
		
		ProductType productType = productDao.getProductTypeByid(newOrderMessage.getOrderType().getProduct().getId());
		int needamount = newOrderMessage.getOrderType().getAmount();
		int Sku = Integer.parseInt(productType.getSku());
		if(Sku>=needamount){
			productDao.updateProductSku(needamount,productType.getId());
			OrderType orderType = new OrderType();
			orderType.setAmount(needamount);
			orderType.setCustomer(newOrderMessage.getCustomerType());
			orderType.setProduct(productType);
			orderType.setTimeStamp(new Date());
			orderType.setIspay(0);
			orderType.setMoney(newOrderMessage.getOrderType().getMoney());
			orderDao.addOrder(orderType );
			return 1;
		}
		return 0;
	}
	
	
	@Override
	public int preTransCallback(Integer orderid) {
		orderDao.UpdateOrder(orderid);
		return 1;
	}


	@Override
	public void updateamount(int orderid,int amount) {
		orderDao.updateproductamont(orderid, amount);
	}


	
	

}
