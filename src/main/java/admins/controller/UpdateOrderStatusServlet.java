package admins.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import members.model.OrderDao;

public class UpdateOrderStatusServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String orderstatus = request.getParameter("orderstatus");
		String order_id = request.getParameter("order_id");
		
		OrderDao orderdao = new OrderDao();
		orderdao.updateOrderStatus(Integer.parseInt(orderstatus), Integer.parseInt(order_id));
		
		RequestDispatcher rd = request.getRequestDispatcher("orderStatus.jsp");
        rd.forward(request, response);
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
