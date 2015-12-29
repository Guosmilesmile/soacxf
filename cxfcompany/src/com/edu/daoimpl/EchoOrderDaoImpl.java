package com.edu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.EchoOrderDao;
import com.edu.entity.OrderType;
import com.edu.entity.OrderView;
import com.edu.util.DBUtil;

public class EchoOrderDaoImpl extends BaseDaoImpl<OrderType> implements EchoOrderDao{

	@Override
	public List<OrderView> getOrderList() {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet  = null;
		List<OrderView> list = new ArrayList<OrderView>();
		try {
			String sql = "select o.id, c.firstname,c.lastname, p.name, p.manufacture, p.cost, o.amount from o_order o, p_product p, c_customer c where o.customerid = c.id and o.productid = p.id";
			openConnection = DBUtil.openConnection();
			prepareStatement = openConnection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				String orderId = resultSet.getString(1);
				String custommerName = resultSet.getString(2) + " " + resultSet.getString(3);
				String productName = resultSet.getString(4);
				String productManufacture = resultSet.getString(5);
				int cost = resultSet.getInt(6) * resultSet.getInt(7);
				OrderView orderView = new OrderView(orderId, custommerName, productName, productManufacture, cost);
				list.add(orderView);
			}
			return list;
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
		return list;
	}

}
