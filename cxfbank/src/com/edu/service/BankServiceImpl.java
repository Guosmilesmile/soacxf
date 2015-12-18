package com.edu.service;

import javax.jws.WebService;

import com.edu.message.cancelPreDepositMessage;
import com.edu.message.preDepositRequestMessage;
import com.edu.message.transferFundsMessage;

@WebService(endpointInterface = "com.edu.service.IBankService")
public class BankServiceImpl implements IBankService {


	@Override
	public int BankPreDeposit(preDepositRequestMessage preDepositRequestMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cancelPreDeposit(cancelPreDepositMessage cancelPreDepositMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int transferFunds(transferFundsMessage transferFundsMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

}