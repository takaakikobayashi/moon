package admins.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import members.model.OrderBean;
import members.model.OrderDao;

public class ManagementServlet extends HttpServlet {
	
	@Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		OrderDao orderdao = new OrderDao();
		ArrayList<OrderBean> earnings = orderdao.getEarningPrice();
		request.setAttribute("earnings", earnings);
		
		RequestDispatcher rd = request.getRequestDispatcher("management.jsp");
        rd.forward(request, response);
	}
	
	@Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}