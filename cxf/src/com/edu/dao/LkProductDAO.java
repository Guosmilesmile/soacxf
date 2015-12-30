package com.edu.dao;
import java.util.List;

import com.edu.entity.ProductType;
public interface LkProductDAO {
	/**
	 * 获取所有的商品列表
	 */
	List <ProductType> getProductList();


}
