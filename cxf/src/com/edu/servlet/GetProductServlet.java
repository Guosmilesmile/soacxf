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

import com.alibaba.fastjson.JSON;
import com.edu.dao.ICustomerTypeDao;
import com.edu.daoimpl.CustomerTypeDaoImpl;
import com.edu.entity.CustomerType;
import com.edu.entity.OrderType;
import com.edu.entity.ProductType;
import com.edu.message.newOrderMessage;
import com.edu.service.CustomerServiceImpl;
import com.edu.service.ICompanySerivce;
import com.edu.service.ICustomerService;
import com.edu.util.FastJsonTool;

/**
 * Servlet implementation class SendOrderServlet
 */
@WebServlet("/GetProductServlet")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
		//getBean()名是？
		ICustomerService customerService = new CustomerServiceImpl();
		List <ProductType> products=customerService.getAllProduct();
		PrintWriter writer = response.getWriter();
		writer.write(FastJsonTool.createJsonString(products));
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
