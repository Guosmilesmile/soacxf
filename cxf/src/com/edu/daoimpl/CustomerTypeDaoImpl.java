package com.edu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.ls.LSException;

import com.edu.dao.ICustomerTypeDao;
import com.edu.entity.CustomerType;
import com.edu.entity.OrderType;
import com.edu.entity.ProductType;
import com.edu.util.DBUtil;
import com.sun.org.apache.regexp.internal.REUtil;

public class CustomerTypeDaoImpl extends BaseDaoImpl<CustomerType> implements ICustomerTypeDao{

	@Override
	public CustomerType getCustomerTypeByid(Integer id) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet  = null;
		CustomerType customerType = new CustomerType();
		try {
			String sql = "select * from c_customer where id=?";
			openConnection = DBUtil.openConnection();
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				String customerid = resultSet.getString(2);
				String firstname = resultSet.getString(3);
				String lastname  =resultSet.getString(4);
				String street = resultSet.getString(5);
				String city = resultSet.getString(6);
				String zipcode = resultSet.getString(7);
				String country = resultSet.getString(8);
				String phonenumber = resultSet.getString(9);
				customerType = new CustomerType(id,customerid, firstname, lastname, street, city, zipcode, country, phonenumber);
			}
			return customerType;
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
		return customerType;
	}

	@Override
	public List<OrderType> getOrderTypes(int flag) {
		List<OrderType> list = new ArrayList<OrderType>();
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet  = null;
		CustomerType customerType = new CustomerType();
		try {
			String sql = "select * from o_order where ispay=?";
			openConnection = DBUtil.openConnection();
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setInt(1, flag);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				String orderId = resultSet.getString(1);
				CustomerType customer = new CustomerType();
				customer.setId(resultSet.getInt(2));
				ProductType product = new ProductType();
				product.setId(resultSet.getInt(3));
				int amount = resultSet.getInt(4);
				Date timeStamp = resultSet.getDate(5);
				Integer ispay = resultSet.getInt(6);
				double money = resultSet.getInt(7);
				OrderType orderType = new OrderType(orderId, customer, product, amount, timeStamp, 2, ispay, money);
				list.add(orderType);
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
