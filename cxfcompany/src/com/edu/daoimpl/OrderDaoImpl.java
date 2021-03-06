package com.edu.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.edu.dao.IOrderDao;
import com.edu.entity.OrderType;
import com.edu.util.DBUtil;

public class OrderDaoImpl implements IOrderDao{

	@Override
	public boolean addOrder(OrderType orderType) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		try {
			String sql = "insert into o_order (customerid,productid,amount,timestamp,ispay,money) value (?,?,?,now(),0,?)";
			openConnection = DBUtil.openConnection();
			openConnection.setAutoCommit(false);
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setInt(1, orderType.getCustomer().getId());
			prepareStatement.setInt(2, orderType.getProduct().getId());
			prepareStatement.setInt(3, orderType.getAmount());
			prepareStatement.setDouble(4, orderType.getMoney());
			prepareStatement.execute();
			return true;
		} catch (Exception e) {
			try {
				openConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				prepareStatement.close();
				openConnection.commit();
				openConnection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	@Override
	public boolean UpdateOrder(Integer id) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		try {
			String sql = "update  o_order set  ispay = 1 where id=?";
			openConnection = DBUtil.openConnection();
			openConnection.setAutoCommit(false);
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			return true;
		} catch (Exception e) {
			try {
				openConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				prepareStatement.close();
				openConnection.commit();
				openConnection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}

	@Override
	public void updateproductamont(int orderid,int amount) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		try {
			String sql = "update p_product set sku=sku-? where id = (select productid from o_order where id=?)";
			openConnection = DBUtil.openConnection();
			openConnection.setAutoCommit(false);
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setInt(1, amount);
			prepareStatement.setInt(2, orderid);
			prepareStatement.execute();
		} catch (Exception e) {
			try {
				openConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				prepareStatement.close();
				openConnection.commit();
				openConnection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
