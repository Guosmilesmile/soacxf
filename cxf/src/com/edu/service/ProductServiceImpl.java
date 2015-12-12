package com.edu.service;

import javax.jws.WebService;

import com.edu.entity.User;
@WebService(endpointInterface = "com.edu.service.IProductService")
public class ProductServiceImpl implements IProductService{

	@Override
	public User getUserById(Integer id) {
		User user = new User();
		user.setName(id+"");
		return user;
	}

}
