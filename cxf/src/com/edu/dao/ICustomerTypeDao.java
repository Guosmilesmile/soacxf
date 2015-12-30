package com.edu.dao;


import java.util.List;

import com.edu.entity.CustomerType;
import com.edu.entity.OrderType;

public interface ICustomerTypeDao extends BaseDao<CustomerType>{
	/**
	 * 通过id获取用户信息
	 * @param id
	 * @return
	 */
	public CustomerType getCustomerTypeByid(Integer id);
	
	public List<OrderType> getOrderTypes(int flag,int customerid);
}
