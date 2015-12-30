package com.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.dao.EchoOrderDao;
import com.edu.dao.ICustomerTypeDao;
import com.edu.daoimpl.CustomerTypeDaoImpl;
import com.edu.daoimpl.EchoOrderDaoImpl;
import com.edu.entity.CustomerType;
import com.edu.entity.OrderType;
import com.edu.entity.OrderView;
import com.edu.entity.ProductType;
import com.edu.message.newOrderMessage;
import com.edu.service.ICompanySerivce;
import com.edu.util.FastJsonTool;

/**
 * Servlet implementation class GetOrderListServlet
 */
@WebServlet("/GetOrderListServlet")
public class GetOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderListServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
		int isPay = Integer.parseInt(request.getParameter("isPay"));
		EchoOrderDao orderDao = new EchoOrderDaoImpl();
		List<OrderView> list = orderDao.getOrderList(isPay);
		
		PrintWriter writer = response.getWriter();
		String orderList = FastJsonTool.createJsonString(list);
		writer.write(orderList);
		writer.close();
	}

}
