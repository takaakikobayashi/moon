package members.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import members.model.ReviewBean;
import members.model.ReviewDao;

public class ReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ReviewServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int item_id = Integer.parseInt(request.getParameter("item_id"));
    	int member_id = Integer.parseInt(request.getParameter("member_id"));
    	
    	int review_star = Integer.parseInt(request.getParameter("rate"));
    	String review_title = request.getParameter("review_title");
    	String review = request.getParameter("review");
    	Date created_at = new Date(System.currentTimeMillis());
    	Date updated_at = new Date(System.currentTimeMillis());
    	
    	ReviewBean reviewBean = new ReviewBean();
    	reviewBean.setReviewStar(review_star);
    	reviewBean.setReviewTitle(review_title);
    	reviewBean.setReview(review);  
    	reviewBean.setCreatedAt(created_at);
    	reviewBean.setUpdatedAt(updated_at);
    	
    	ReviewDao reviewDao = new ReviewDao();
    	reviewDao.ReviewRegister(item_id, reviewBean, member_id);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("itemdetailservlet?item_id="+item_id);
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }

}
