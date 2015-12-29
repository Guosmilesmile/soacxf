package com.edu.dao;

import com.edu.entity.ProductType;

public interface IProductDao extends BaseDao<ProductType>{
	/**
	 * 通过id获取商品详情
	 * @param id
	 * @return
	 */
	public ProductType getProductTypeByid(Integer id);
}
