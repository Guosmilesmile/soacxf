package com.edu.dao;

import com.edu.entity.CustomerType;

public interface ICustomerTypeDao extends BaseDao<CustomerType>{
	/**
	 * 通过id获取用户信息
	 * @param id
	 * @return
	 */
	public CustomerType getCustomerTypeByid(Integer id);
}
