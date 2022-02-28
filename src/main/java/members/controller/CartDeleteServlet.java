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

public class CartDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CartDeleteServlet() {
        super();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int cart_id = Integer.parseInt(request.getParameter("cart_id"));
    	HttpSession session = request.getSession();
		ArrayList<CartBean> cartList = (ArrayList<CartBean>) session.getAttribute("cart_item");
		cartList.remove(cart_id);
		session.setAttribute("cart_item", cartList);
        
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
