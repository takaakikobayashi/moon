package members.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import members.model.FavoriteDao;
import members.model.LoginUserBean;

public class UnFavoriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public UnFavoriteServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	LoginUserBean loginUser = (LoginUserBean)session.getAttribute("member");
    	int item_id = Integer.parseInt(request.getParameter("item_id"));
    	int member_id = loginUser.getMemberId();
    	
    	FavoriteDao favoriteDao = new FavoriteDao();
    	favoriteDao.removeFavorite(member_id, item_id);
    		
    	RequestDispatcher rd = request.getRequestDispatcher("itemdetailservlet?item_id="+item_id);
        rd.forward(request, response);
  
    	
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }

}
