package members.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import members.model.CartBean;
import members.model.LoginUserBean;
import members.model.OrderBean;
import members.model.OrderDao;
import members.model.OrderDetailDao;

public class OrderFinalizeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @SuppressWarnings("unchecked" )
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        OrderDao orderdao = new OrderDao();
        HttpSession order_session = request.getSession();
        HttpSession session = request.getSession();
        LoginUserBean loginUser = (LoginUserBean)session.getAttribute("member");
        int member_id = 0;
        if (loginUser != null) {
        	member_id = loginUser.getMemberId();
        }
        if (order_session.getAttribute("order") != null) {
			OrderBean order = (OrderBean) order_session.getAttribute("order");
			String first_name = order.getFirstName();
			String last_name = order.getLastName();
			String postal_code = order.getPostalCode();
			String address1 = order.getAddress1();
			String address2 = order.getAddress2();
			String address3 = order.getAddress3();
			String mail = order.getMail();
			String phone_number = order.getPhoneNumber();
			int total_price = order.getTotalPrice();
			int postage = order.getPostage();
			int payment = order.getPayment();
			int point = order.getPoint();
			String remarks = order.getRemarks();
	        int order_id = orderdao.confirmOrder(member_id,first_name,last_name,postal_code,address1,address2,address3,mail,phone_number,total_price,postage,payment,point,remarks);
	        
	        ArrayList<CartBean> buy_item = (ArrayList<CartBean>) session.getAttribute("cart_item");
	    
		    for (CartBean bean : buy_item) {
		        int order_product_id = bean.getProductId();
		        int order_product_amount = bean.getAmount();
		        int order_product_price = bean.getPrice();
		        OrderDetailDao orderDetailDao = new OrderDetailDao();
		        orderDetailDao.confirmOrderDetail(order_id, order_product_id, order_product_amount, order_product_price);
		    }
		    
		    session.removeAttribute("cart_item");
		    
		    RequestDispatcher rd = request.getRequestDispatcher("orderComplete.jsp");
		    rd.forward(request, response);
    
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
