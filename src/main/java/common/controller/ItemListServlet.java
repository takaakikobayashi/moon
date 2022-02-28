package common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.ItemBean;
import common.model.ItemDao;

public class ItemListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ItemListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String category_id = request.getParameter("category_id");
        String check_price = request.getParameter("check_price");
        ItemDao itemDao = new ItemDao();
        
        if ( check_price != null ) {
        	
        	ArrayList<ItemBean> itemBeanList  = itemDao.selectItem(check_price);

	        if (itemBeanList != null) {
	            request.setAttribute("itemList", itemBeanList);
	
	            RequestDispatcher rd = request.getRequestDispatcher("itemList.jsp");
	            rd.forward(request, response);
	        } else {
	            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
	        }
	        
        } else if (category_id == null) {
        	
        	ArrayList<ItemBean> itemBeanList  = itemDao.selectItem();

	        if (itemBeanList != null) {
	            request.setAttribute("itemList", itemBeanList);
	
	            RequestDispatcher rd = request.getRequestDispatcher("itemList.jsp");
	            rd.forward(request, response);
	        } else {
	            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
	        }
        
        } else {
        
        	ArrayList<ItemBean> itemCategoryList  = itemDao.selectCategoryItem(Integer.parseInt(category_id));

	        if (itemCategoryList != null) {
	            request.setAttribute("itemList", itemCategoryList);
	
	            RequestDispatcher rd = request.getRequestDispatcher("itemList.jsp");
	            rd.forward(request, response);
	        } else {
	            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
	        }
        
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
