package com.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dao.ICustomerTypeDao;
import com.edu.daoimpl.CustomerTypeDaoImpl;
import com.edu.entity.CustomerType;
import com.edu.entity.OrderType;
import com.edu.service.CustomerServiceImpl;
import com.edu.util.FastJsonTool;

/**
 * Servlet implementation class GetNoPayOrderServlet
 */
@WebServlet("/GetNoPayOrderServlet")
public class GetNoPayOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNoPayOrderServlet() {
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
		String customerid = request.getParameter("id");
		ICustomerTypeDao customerTypeDao = new CustomerTypeDaoImpl();
		List<OrderType> orderTypes = customerTypeDao.getOrderTypes(0,Integer.parseInt(customerid));
		PrintWriter writer = response.getWriter();
		writer.write(FastJsonTool.createJsonString(orderTypes));
		writer.close();
	}

}
