package common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.ItemBean;
import common.model.ItemDao;

public class ItemDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ItemDetailServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String item_id = request.getParameter("item_id");

        ItemDao itemDao = new ItemDao();
        ItemBean itemBean  = itemDao.selectItem(Integer.parseInt(item_id));

        if (itemBean != null) {
            request.setAttribute("itemBean", itemBean);

            RequestDispatcher rd = request.getRequestDispatcher("itemDetail.jsp");
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
