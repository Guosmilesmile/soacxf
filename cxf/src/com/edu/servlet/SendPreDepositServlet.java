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

import com.edu.daoimpl.CustomerDaoImpl;
import com.edu.entity.CustomerType;
import com.edu.message.preDepositRequestMessage;
import com.edu.service.IBankService;
import com.edu.service.IHelloService;

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
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
        IBankService bankService = (IBankService) context.getBean("bank");
        CustomerDaoImpl customerDao= new CustomerDaoImpl();
        CustomerType customer = customerDao.getCustomerTypeById(1);
		String myCreditCardId = 1+"";
		Double funds = Double.parseDouble(request.getParameter("funds"));
		String salerCreditCardId = 2+"";
		preDepositRequestMessage preDepositRequestMessage = new preDepositRequestMessage(customer, myCreditCardId, funds, salerCreditCardId);
		int bankPreDeposit = bankService.BankPreDeposit(preDepositRequestMessage );
		PrintWriter printWriter = response.getWriter();
		printWriter.write(bankPreDeposit+"");
		printWriter.close();
	}

}
