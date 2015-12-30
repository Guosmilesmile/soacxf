package com.edu.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.LkProductDAO;
import com.edu.entity.CustomerType;
import com.edu.entity.ProductType;
import com.edu.util.DBUtil;
import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.org.glassfish.external.statistics.annotations.Reset;



public class LKProductDAOImpl extends BaseDaoImpl<ProductType>implements LkProductDAO{

	@Override
	public List<ProductType> getProductList() {
		List<ProductType> list = new ArrayList<ProductType>();
		String sql = " select * from p_product";
		Connection connection = DBUtil.openConnection();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String sku =resultSet.getString(3);
				String manufacture = resultSet.getString(4);
				Double cost = resultSet.getDouble(5);
				ProductType productType = new ProductType(id, name, sku, manufacture, cost);
				list.add(productType);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				return null;
			}
		}
	}

}
