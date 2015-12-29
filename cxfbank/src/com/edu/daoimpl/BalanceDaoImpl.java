package com.edu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edu.dao.IBalanceDao;
import com.edu.entity.BalanceType;
import com.edu.util.DBUtil;

public class BalanceDaoImpl extends BaseDaoImpl<BalanceType> implements IBalanceDao{

	@Override
	public Double getBalancebyCustomerid(Integer customerid) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		ResultSet executeQuery  = null;
		try {
			String sql = "select balance from b_balance where id=?";
			openConnection = DBUtil.openConnection();
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setInt(1, customerid);
			executeQuery = prepareStatement.executeQuery();
			Double balance = 0.0;
			while(executeQuery.next()){
				balance = executeQuery.getDouble(1);
			}
			return balance;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				executeQuery.close();
				prepareStatement.close();
				openConnection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return -1.0;
	}

	@Override
	public boolean UpdatePreBalance(Integer customerid, Double funds) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		try {
			String sql = "update b_balance set prebalance=prebalance+?,balance=balance-?  where customerid=?";
			System.out.println(sql);
			openConnection = DBUtil.openConnection();
			openConnection.setAutoCommit(false);
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setDouble(1, funds);
			prepareStatement.setDouble(2, funds);
			prepareStatement.setInt(3, customerid);
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
	public boolean UpdateBalance(Integer customerid, Double funds) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		try {
			String sql = "update b_balance set balance=balance+? where id=?";
			openConnection = DBUtil.openConnection();
			openConnection.setAutoCommit(false);
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setDouble(1, funds);
			prepareStatement.setInt(2, customerid);
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
	public boolean TransferBalance(Integer customerid, Integer receiverid,
			Double funds) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		try {
			String sql = "update b_balance set prebalance=prebalance-? where id=?";
			openConnection = DBUtil.openConnection();
			openConnection.setAutoCommit(false);
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setDouble(1, funds);
			prepareStatement.setInt(2, customerid);
			prepareStatement.execute();
			sql = "update b_balance set balance=balance+? where id=?";
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setDouble(1, funds);
			prepareStatement.setInt(2, receiverid);
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
	
	
	
}	
