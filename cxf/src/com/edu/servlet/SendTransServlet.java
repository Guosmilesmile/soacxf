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

import com.edu.entity.CustomerType;
import com.edu.message.transferFundsMessage;
import com.edu.service.IBankService;

/**
 * Servlet implementation class SendTransServlet
 */
@WebServlet("/SendTransServlet")
public class SendTransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendTransServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
		String id = request.getParameter("id");
		String toid = request.getParameter("toid");
		String orderid = request.getParameter("orderid");
        IBankService bankService = (IBankService) context.getBean("bank");
        transferFundsMessage transferFundsMessage = new transferFundsMessage();
        CustomerType from  =new CustomerType();
        from.setId(Integer.parseInt(id) );
        CustomerType to  =new CustomerType();
        to.setId(Integer.parseInt(toid ));
        transferFundsMessage.setOrderid(Integer.parseInt(orderid));
        transferFundsMessage.setCustomerType(from);
        transferFundsMessage.setReceiverCustomerType(to);
        int transferFunds = -2;
        transferFunds = bankService.transferFunds(transferFundsMessage);
		PrintWriter writer = response.getWriter();
		if(transferFunds==-2){
			writer.write("连接失败，请重新连接");
			writer.close();
		}else{
			if(transferFunds==0){
				writer.write("操作失败!");
			}else if(transferFunds==1){
				writer.write("转账成功!");
			}else{
				writer.write("操作失败");
			}
			writer.close();
			
		}
	}

}
