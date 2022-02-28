package members.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.model.ItemBean;
import members.model.FavoriteDao;
import members.model.LoginUserBean;

public class MyFavoriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public MyFavoriteServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	LoginUserBean loginUser = (LoginUserBean)session.getAttribute("member");
    	int member_id = loginUser.getMemberId();
    	
    	FavoriteDao favoriteDao = new FavoriteDao();
    	ArrayList<ItemBean> itemBeanList = favoriteDao.myFavorite(member_id);
    	
    	if (itemBeanList != null) {
            request.setAttribute("itemList", itemBeanList);

            RequestDispatcher rd = request.getRequestDispatcher("itemList.jsp");
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
