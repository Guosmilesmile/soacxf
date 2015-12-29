package com.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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
import com.edu.entity.ProductType;
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		String amount = request.getParameter("amount");
		String productid = request.getParameter("productid");
		String money = request.getParameter("money");
		System.out.println(money);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-client.xml");
	    ICompanySerivce companySerivce =   (ICompanySerivce) context.getBean("company");
		OrderType orderType = new OrderType();
		
		
		ICustomerTypeDao customerTypedao = new CustomerTypeDaoImpl();
		CustomerType customerType = customerTypedao.getCustomerTypeByid(Integer.parseInt(id));
		
		orderType.setCustomer(customerType);
		orderType.setAmount(Integer.parseInt(amount));
		orderType.setTimeStamp(new Date());
		orderType.setIspay(0);
		ProductType productType = new ProductType();
		productType.setId(Integer.parseInt(productid));
		orderType.setProduct(productType);
		orderType.setMoney(Double.parseDouble(money));
		
		newOrderMessage newOrderMessage = new newOrderMessage(customerType, orderType);
		int res = -2;
		res = companySerivce.placeOrder(newOrderMessage );
		PrintWriter writer = response.getWriter();
		if(res==-2){
			writer.write("连接失败，请重新连接");
			writer.close();
		}else{
			if(res==1){
				writer.write("发送订单成功!");
			}else if(res==0){
				writer.write("库存不足，订单被拒绝");
			}else{
				writer.write("操作失败");
			}
			writer.close();
			
		}
		
	}

}
