package com.edu.dao;

import java.util.List;

import com.edu.entity.OrderType;
import com.edu.entity.OrderView;

public interface EchoOrderDao extends BaseDao<OrderType>{
	/**
	 * 获取订单列表
	 * @return
	 */
	public List<OrderView> getOrderList(int isPay);
	
	/**
	 * 获取账户余额
	 * @param id
	 * @return
	 */
	public double getBalance(int id);
	
	/**
	 * 获取订单价钱
	 * @param order_id
	 * @return
	 */
	public double getMoney(int order_id);
}
