package admins.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.CategoryDao;

public class CategoryStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CategoryStatusServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String status = request.getParameter("status");
    	int category_id = Integer.parseInt(request.getParameter("category_id"));
    	CategoryDao categorydao = new CategoryDao();
//    	ItemDao itemdao = new ItemDao();
    	
    	if (status.equals("changefalse")) {
    		
//    		if (itemdao.categoryItem(category_id) == null) {
    			categorydao.changefalse(category_id);
//    		} else {
//    			request.setAttribute("category_error", "カテゴリを無効にするには該当するカテゴリの登録商品を販売中止にしてください");
//    		}
    		
    	} else if (status.equals("changetrue")) {
    		
    		categorydao.changetrue(category_id);
    		
    	}
    	
    	RequestDispatcher rd = request.getRequestDispatcher("categoryList.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
