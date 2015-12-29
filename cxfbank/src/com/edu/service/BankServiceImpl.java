package com.edu.service;

import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.dao.EchoOrderDao;
import com.edu.dao.IBalanceDao;
import com.edu.dao.IOrderDao;
import com.edu.daoimpl.BalanceDaoImpl;
import com.edu.daoimpl.EchoOrderDaoImpl;
import com.edu.daoimpl.OrderDaoImpl;
import com.edu.entity.OrderType;
import com.edu.message.cancelPreDepositMessage;
import com.edu.message.preDepositRequestMessage;
import com.edu.message.transferFundsMessage;

@WebService(endpointInterface = "com.edu.service.IBankService")
public class BankServiceImpl implements IBankService {
	private IBalanceDao balanceDao = new BalanceDaoImpl();
	private IOrderDao orderDao1 = new OrderDaoImpl();
	@Override
	public int BankPreDeposit(preDepositRequestMessage preDepositRequestMessage) {
		EchoOrderDao orderDao = new EchoOrderDaoImpl();
		OrderType orderType = orderDao.getMoney(preDepositRequestMessage.getOrderid());
		Double balance = balanceDao.getBalancebyCustomerid(preDepositRequestMessage.getCustomer().getId());
		if(balance<preDepositRequestMessage.getFunds())//如果余额小于申请金额
			return 2;//余额不足
		else{
			balanceDao.UpdatePreBalance(preDepositRequestMessage.getCustomer().getId(), orderType.getMoney());
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
			ICompanySerivce companySerivce = (ICompanySerivce) context.getBean("company");
			companySerivce.updateamount(preDepositRequestMessage.getOrderid(),orderType.getAmount() );
			orderDao1.UpdateOrder(preDepositRequestMessage.getOrderid(),1);
			return 1;//成功
		}
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
		IOrderDao orderDao = new OrderDaoImpl();
		EchoOrderDao orderDao1 = new EchoOrderDaoImpl();
		OrderType orderType = orderDao1.getMoney(transferFundsMessage.getOrderid());
		boolean transferBalance = balanceDao.TransferBalance(transferFundsMessage.getCustomerType().getId(), transferFundsMessage.getReceiverCustomerType().getId(), orderType.getMoney());
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
	    ICompanySerivce companySerivce =   (ICompanySerivce) context.getBean("company");
	    companySerivce.preTransCallback(transferFundsMessage.getOrderid());
	    orderDao.UpdateOrder(transferFundsMessage.getOrderid(),2);
		if(transferBalance){
			return 1;
		}
		return 0;
	}

}