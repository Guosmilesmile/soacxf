package com.edu.dao;

import com.edu.entity.OrderType;

public interface IOrderDao {
	/**
	 * 添加订单
	 * @param orderType
	 * @return
	 */
	public boolean addOrder(OrderType orderType);
}
