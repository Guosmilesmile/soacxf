package com.edu.dao;

import com.edu.entity.OrderType;

public interface IOrderDao {
	/**
	 * 添加订单
	 * @param orderType
	 * @return
	 */
	public boolean addOrder(OrderType orderType);

	/**
	 * 修改订单状态
	 * @param id
	 * @return
	 */
	public boolean UpdateOrder(Integer id);
}
