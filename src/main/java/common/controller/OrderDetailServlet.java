package common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import members.model.OrderDetailBean;
import members.model.OrderDetailDao;

public class OrderDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public OrderDetailServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int order_id = Integer.parseInt(request.getParameter("order_id"));
    	HttpSession session = request.getSession();
        session.setAttribute("order_id", order_id);

        OrderDetailDao orderDetailDao = new OrderDetailDao();
        ArrayList<OrderDetailBean> orderDetailBean  = orderDetailDao.selectOrderDetail(order_id);
        
        if (orderDetailBean != null) {
            request.setAttribute("orderDetailBean", orderDetailBean);

            RequestDispatcher rd = request.getRequestDispatcher("orderDetail.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
