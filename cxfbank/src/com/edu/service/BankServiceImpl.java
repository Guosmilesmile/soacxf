package com.edu.service;

import javax.jws.WebService;

import com.edu.dao.IBalanceDao;
import com.edu.daoimpl.BalanceDaoImpl;
import com.edu.message.cancelPreDepositMessage;
import com.edu.message.preDepositRequestMessage;
import com.edu.message.transferFundsMessage;

@WebService(endpointInterface = "com.edu.service.IBankService")
public class BankServiceImpl implements IBankService {
	private IBalanceDao balanceDao = new BalanceDaoImpl();

	@Override
	public int BankPreDeposit(preDepositRequestMessage preDepositRequestMessage) {
		Double balance = balanceDao.getBalancebyCustomerid(preDepositRequestMessage.getCustomer().getId());
		if(balance<preDepositRequestMessage.getFunds())//如果余额小于申请金额
			return 2;//余额不足
		else{
			boolean updateBalance = balanceDao.UpdateBalance(preDepositRequestMessage.getCustomer().getId(), preDepositRequestMessage.getFunds());
			if(updateBalance){
				return 1;//成功
			}
		}
		return 0;
	}

	@Override
	public int cancelPreDeposit(cancelPreDepositMessage cancelPreDepositMessage) {
		Double total = (cancelPreDepositMessage.getOrderType().getAmount())*1.0*(cancelPreDepositMessage.getOrderType().getProduct().getCost());
		boolean updateBalance = balanceDao.UpdateBalance(cancelPreDepositMessage.getOrderType().getCustomer().getId(), -1*total);
		if(updateBalance){
			return 1;
		}
		return 0;
	}

	@Override
	public int transferFunds(transferFundsMessage transferFundsMessage) {
		boolean transferBalance = balanceDao.TransferBalance(transferFundsMessage.getCustomerType().getId(), transferFundsMessage.getReceiverCustomerType().getId(), transferFundsMessage.getFunds());
		if(transferBalance){
			return 1;
		}
		return 0;
	}

}