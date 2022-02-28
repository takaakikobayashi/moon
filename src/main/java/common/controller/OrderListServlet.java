package common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import members.model.LoginUserBean;
import members.model.OrderBean;
import members.model.OrderDao;

public class OrderListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderDao orderDao = new OrderDao();
        HttpSession session = request.getSession();
        LoginUserBean loginUser = (LoginUserBean)session.getAttribute("member");
        int member_id = loginUser.getMemberId();
        ArrayList<OrderBean> orderBean = (ArrayList<OrderBean>)orderDao.selectOrder(member_id);
        
        if (orderBean != null) {
            request.setAttribute("orderBean", orderBean);

            RequestDispatcher rd = request.getRequestDispatcher("orderList.jsp");
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
