package admins.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.CategoryBean;
import common.model.CategoryDao;

public class CategoryAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CategoryAddServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String category = request.getParameter("category");
    	
    	CategoryBean categoryBean = new CategoryBean();
    	categoryBean.setName(category);
    	
    	CategoryDao categoryDao = new CategoryDao();
    	categoryDao.registerCategory(categoryBean);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("categoryList.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
