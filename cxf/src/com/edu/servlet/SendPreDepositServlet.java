package com.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.dao.ICustomerTypeDao;
import com.edu.daoimpl.CustomerTypeDaoImpl;
import com.edu.entity.CustomerType;
import com.edu.message.preDepositRequestMessage;
import com.edu.service.IBankService;

/**
 * Servlet implementation class SendPreDepositServlet
 */
@WebServlet("/SendPreDepositServlet")
public class SendPreDepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendPreDepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String salerCreditCardId = request.getParameter("toid");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
        IBankService bankService = (IBankService) context.getBean("bank");
        ICustomerTypeDao customerTypeDao= new CustomerTypeDaoImpl();
        CustomerType customer = customerTypeDao.getCustomerTypeByid(Integer.parseInt(id));
		String myCreditCardId = customer.getId()+"";
		Double funds = Double.parseDouble(request.getParameter("funds"));
		preDepositRequestMessage preDepositRequestMessage = new preDepositRequestMessage(customer, myCreditCardId, funds, salerCreditCardId);
		int bankPreDeposit = -2;
		bankPreDeposit = bankService.BankPreDeposit(preDepositRequestMessage );
		if(bankPreDeposit!=-2){
			PrintWriter writer = response.getWriter();
			if(bankPreDeposit==2){
				writer.write("操作失败，余额不足!");
			}else if(bankPreDeposit==1){
				writer.write("发送订单成功，请在订单列表中查看订单状态");
			}else{
				writer.write("操作失败");
			}
			writer.close();
		}else{
			PrintWriter writer = response.getWriter();
			writer.write("连接失败，请重新连接");
			writer.close();
		}
	}

}
