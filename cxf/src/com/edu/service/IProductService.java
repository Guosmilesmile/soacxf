package com.edu.service;

import javax.jws.WebService;

import com.edu.entity.User;
@WebService
public interface IProductService {
	public User getUserById(Integer id);
}
