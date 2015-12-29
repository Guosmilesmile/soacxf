package com.edu.dao;

import java.util.List;

import com.edu.entity.OrderType;
import com.edu.entity.OrderView;

public interface EchoOrderDao extends BaseDao<OrderType>{
	/**
	 * 获取订单列表
	 * @return
	 */
	public List<OrderView> getOrderList();
}
