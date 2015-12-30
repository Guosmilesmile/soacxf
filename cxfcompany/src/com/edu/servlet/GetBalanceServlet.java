package com.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dao.EchoOrderDao;
import com.edu.daoimpl.EchoOrderDaoImpl;
import com.edu.entity.OrderView;
import com.edu.util.FastJsonTool;

/**
 * Servlet implementation class GetBalance
 */
@WebServlet("/GetBalanceServlet")
public class GetBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBalanceServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		EchoOrderDao orderDao = new EchoOrderDaoImpl();
		double balance = orderDao.getBalance(id);
		
		PrintWriter writer = response.getWriter();
		writer.write(String.valueOf(balance));
		writer.close();
	}
}
