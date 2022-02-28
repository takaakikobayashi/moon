package admins.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.CategoryBean;
import common.model.CategoryDao;

public class CategoryListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CategoryListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	CategoryDao categoryDao = new CategoryDao();
    	
    	ArrayList<CategoryBean> categoryBeanList  = categoryDao.selectcategory();
    	
    	if (categoryBeanList != null) {
            request.setAttribute("categoryList", categoryBeanList);

            RequestDispatcher rd = request.getRequestDispatcher("categoryList.jsp");
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
