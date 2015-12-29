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
import com.edu.entity.OrderType;
import com.edu.message.newOrderMessage;
import com.edu.service.ICompanySerivce;

/**
 * Servlet implementation class SendOrderServlet
 */
@WebServlet("/SendOrderServlet")
public class SendOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendOrderServlet() {
        super();
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
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
	    ICompanySerivce companySerivce =   (ICompanySerivce) context.getBean("company");
		OrderType orderType = new OrderType();
		ICustomerTypeDao customerTypedao = new CustomerTypeDaoImpl();
		CustomerType customerType = customerTypedao.getCustomerTypeByid(Integer.parseInt(id));
		newOrderMessage newOrderMessage = new newOrderMessage(customerType, orderType);
		int res = -2;
		res = companySerivce.placeOrder(newOrderMessage );
		if(res!=-2){
			PrintWriter writer = response.getWriter();
			writer.write("发送订单成功，请在订单列表中查看订单状态");
			writer.close();
		}else{
			PrintWriter writer = response.getWriter();
			writer.write("连接失败，请重新连接");
			writer.close();
		}
		
	}

}
