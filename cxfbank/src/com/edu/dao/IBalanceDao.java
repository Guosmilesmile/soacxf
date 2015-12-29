package com.edu.dao;

import com.edu.entity.BalanceType;

public interface IBalanceDao extends BaseDao<BalanceType>{
	
	/**
	 * 通过id获取存款
	 * @param customerid
	 * @return
	 */
	public Double getBalancebyCustomerid(Integer customerid);
	/**
	 * 修改预存款
	 * @param customerid
	 * @param funds
	 * @return
	 */
	public boolean UpdatePreBalance(Integer customerid,Double funds);
	
	/**
	 * 修改存款
	 * @param customerid
	 * @param funds
	 * @return
	 */
	public boolean UpdateBalance(Integer customerid,Double funds);
	
	/**
	 * 转钱 
	 * @param customerid
	 * @param funds
	 * @return
	 */
	public boolean TransferBalance(Integer customerid,Integer receiverid,Double funds);
}
