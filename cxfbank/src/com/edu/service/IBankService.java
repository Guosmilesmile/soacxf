package com.edu.service;

import javax.jws.WebService;

/**
 * 银行服务接口
 * @author Gy
 *
 */
@WebService
public interface IBankService {
	/**
	 * 预存款操作
	 * @param money
	 */
	public int BankPreDeposit(int money);
	
	
	public int cancelPreDeposit();
}
