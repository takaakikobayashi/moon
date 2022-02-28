package admins.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.CategoryDao;

public class CategoryEditServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String category_id = request.getParameter("category_id");
		String name = request.getParameter("name");
		
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.editcategory(name, Integer.parseInt(category_id));
		
		RequestDispatcher rd = request.getRequestDispatcher("categoryList.jsp");
        rd.forward(request, response);
	}

}
