package com.edu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edu.dao.IProductDao;
import com.edu.entity.CustomerType;
import com.edu.entity.ProductType;
import com.edu.util.DBUtil;

public class ProductTypeDaoImpl extends BaseDaoImpl<ProductType> implements IProductDao{

	@Override
	public ProductType getProductTypeByid(Integer id) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet  = null;
		ProductType productType = new ProductType();
		try {
			String sql = "select * from p_product where id=?";
			openConnection = DBUtil.openConnection();
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				String name = resultSet.getString(2);
				String sku= resultSet.getString(3);
				String manufacture= resultSet.getString(4);
				Double cost= resultSet.getDouble(5);
				productType = new ProductType(id, name, sku, manufacture, cost);
			}
			return productType;
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
		return productType;
	}

	@Override
	public boolean updateProductSku(int amount,int id) {
		Connection openConnection = null ;
		PreparedStatement prepareStatement = null;
		try {
			String sql = "update p_product set sku=sku-? where id=?";
			openConnection = DBUtil.openConnection();
			openConnection.setAutoCommit(false);
			prepareStatement = openConnection.prepareStatement(sql);
			prepareStatement.setInt(1, amount);
			prepareStatement.setInt(2, id);
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
