package com.edu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.EchoOrderDao;
import com.edu.entity.OrderType;
import com.edu.util.DBUtil;

public class EchoOrderDaoImpl extends BaseDaoImpl<OrderType> implements EchoOrderDao{

	
	@Override
	public OrderType getMoney(int order_id) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet  = null;
		OrderType orderType = new OrderType();
		try {
			String sql = "select money,amount from o_order o where o.id = "+order_id;
			openConnection = DBUtil.openConnection();
			prepareStatement = openConnection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				orderType.setMoney(resultSet.getInt(1));
				orderType.setAmount(resultSet.getInt(2));
			}
			return orderType;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
				prepareStatement.close();
				openConnection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orderType;
	}

}
