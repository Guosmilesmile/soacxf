package com.edu.dao;

import java.util.List;

import com.edu.entity.OrderType;

public interface EchoOrderDao extends BaseDao<OrderType>{
	
	
	/**
	 * 获取订单价钱
	 * @param order_id
	 * @return
	 */
	public OrderType getMoney(int order_id);
}
