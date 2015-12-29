package com.edu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edu.entity.CustomerType;
import com.edu.util.DBUtil;

public class CustomerDaoImpl {
	public void testget(){
		Connection openConnection = DBUtil.openConnection();
		String sql ="select * from c_customer ";
		try {
			PreparedStatement prepareStatement = openConnection.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt(1);
				System.out.println(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public CustomerType getCustomerTypeById(Integer id){
		Connection openConnection = DBUtil.openConnection();
		String sql ="select * from c_customer where id=?";
		try {
			PreparedStatement prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			CustomerType customerType = null;
			while(resultSet.next()){
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String street= resultSet.getString("street");
				String city= resultSet.getString("city");
				String zipcode= resultSet.getString("zipcode");
				String country= resultSet.getString("country");
				String phonenumber= resultSet.getString("phonenumber");
				customerType = new CustomerType(id+"", firstname , lastname, street, city, zipcode, country, phonenumber);
			}
			return customerType;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
