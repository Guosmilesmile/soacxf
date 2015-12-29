package com.edu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.edu.dao.ICustomerTypeDao;
import com.edu.entity.CustomerType;
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
	
}
