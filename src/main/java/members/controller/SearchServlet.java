package members.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.CategoryDao;
import common.model.ItemBean;
import common.model.ItemDao;

public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String search_word = request.getParameter("search_word");
    	
    	ItemDao itemDao = new ItemDao();
    	CategoryDao categoryDao = new CategoryDao();
    	ArrayList<ItemBean> all_itemList = itemDao.getSearchAllItem();
    	ArrayList<ItemBean> itemBeanList  = new ArrayList<ItemBean>();
    	String compare_search_word = "^.*" + search_word + ".*$";
    	
    	for (ItemBean bean : all_itemList) {
    		
    		int search_category_id = bean.getCategoryId();
    		String search_category_name = categoryDao.getNameString(search_category_id);
    		String search_item_name = bean.getName();
    		
    		if (search_category_name.matches(compare_search_word)) {
    			
    			if (search_word != "") {
    				itemBeanList.add(bean);
    			}
    			
    		} else if (search_item_name.matches(compare_search_word)) {
    			
    			if (search_word != "") {
    				itemBeanList.add(bean);
    			}
    			
    		}
    	}
    	
    	request.setAttribute("itemList", itemBeanList);

        RequestDispatcher rd = request.getRequestDispatcher("itemList.jsp");
        rd.forward(request, response);
    	
    }

}
