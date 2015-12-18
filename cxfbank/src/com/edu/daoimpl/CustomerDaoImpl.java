package com.edu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
