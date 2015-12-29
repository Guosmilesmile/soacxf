package com.edu.service;

import com.edu.dao.IProductDao;
import com.edu.daoimpl.ProductTypeDaoImpl;
import com.edu.entity.ProductType;
import com.edu.message.newOrderMessage;
import com.edu.message.preDepositSuccessMessage;

public class CompanyServiceImpl implements ICompanySerivce{
	IProductDao productDao = new ProductTypeDaoImpl();
	@Override
	public int placeOrder(newOrderMessage newOrderMessage) {
		//查看库存
		
		ProductType productType = productDao.getProductTypeByid(newOrderMessage.getOrderType().getProduct().getId());
		int needamount = newOrderMessage.getOrderType().getAmount();
		int Sku = Integer.parseInt(productType.getSku());
		if(Sku>=needamount){
			productDao.updateProductSku(needamount,productType.getId());
			return 1;
		}
		return 0;
	}

	@Override
	public int preDepositCallback(
			preDepositSuccessMessage preDepositSuccessMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
