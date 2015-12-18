package com.edu.service;

import javax.jws.WebService;

import com.edu.message.cancelPreDepositMessage;
import com.edu.message.preDepositRequestMessage;
import com.edu.message.transferFundsMessage;

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
	public int BankPreDeposit(preDepositRequestMessage preDepositRequestMessage);
	
	/**
	 * 取消预存款
	 * @return
	 */
	public int cancelPreDeposit(cancelPreDepositMessage cancelPreDepositMessage);
	
	/**
	 * 转账操作
	 * @param transferFundsMessage
	 * @return
	 */
	public int transferFunds(transferFundsMessage transferFundsMessage);
}
