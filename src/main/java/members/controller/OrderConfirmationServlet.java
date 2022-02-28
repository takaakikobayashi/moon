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
import members.model.OrderBean;

public class OrderConfirmationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public OrderConfirmationServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	
    	HttpSession session = request.getSession();
    	ArrayList<CartBean> buy_item = (ArrayList<CartBean>) session.getAttribute("cart_item");
    	
    	int total_price = 0;
    	
    	for (CartBean bean : buy_item) {
            int order_product_amount = bean.getAmount();
            int order_product_price = bean.getPrice();
            int each_price = order_product_amount * order_product_price;
            total_price += each_price;
        }
        
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String mail = request.getParameter("mail");
        String postal_code = request.getParameter("postal_code");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String address3 = request.getParameter("address3");
        String phone_number = request.getParameter("phone_number");
        int postage = 800;
        String payment = request.getParameter("payment");
        String credit = request.getParameter("credit");
        String point = request.getParameter("point");
        String remarks = request.getParameter("remarks");
        
        OrderBean orderBean = new OrderBean();
        orderBean.setFirstName(first_name);
        orderBean.setLastName(last_name);
        orderBean.setMail(mail);
        orderBean.setPostalCode(postal_code);
        orderBean.setAddress1(address1);
        orderBean.setAddress2(address2);
        orderBean.setAddress3(address3);
        orderBean.setPhoneNumber(phone_number);
        orderBean.setTotalPrice(total_price);
        orderBean.setPostage(postage);
        orderBean.setPayment(Integer.parseInt(payment));
        orderBean.setCredit(credit);
        if (point.equals("")){
        	orderBean.setPoint(0);
        } else {
        	orderBean.setPoint(Integer.parseInt(point));
        }
        orderBean.setRemarks(remarks);
        
        if (orderBean != null) {
            HttpSession orderBean_session = request.getSession();
            orderBean_session.setAttribute("order", orderBean);

            RequestDispatcher rd = request.getRequestDispatcher("orderConfirmation.jsp");
            rd.forward(request, response);
        } else {
        }
    }
}
