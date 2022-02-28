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

public class ReviewEditServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int review_id = Integer.parseInt(request.getParameter("review_id"));
    	
    	int review_star = Integer.parseInt(request.getParameter("rate"));
    	String review_title = request.getParameter("review_title");
    	String review = request.getParameter("review");
    	Date updated_at = new Date(System.currentTimeMillis());
    	
    	ReviewBean reviewBean = new ReviewBean();
    	reviewBean.setReviewStar(review_star);
    	reviewBean.setReviewTitle(review_title);
    	reviewBean.setReview(review); 
    	reviewBean.setUpdatedAt(updated_at);
    	
    	ReviewDao reviewDao = new ReviewDao();
    	reviewDao.editReview(review_id, reviewBean);
    	ReviewBean reviewIdBean = reviewDao.getReview(review_id);
    	int item_id = reviewIdBean.getProductId();
    	
    	RequestDispatcher rd = request.getRequestDispatcher("itemdetailservlet?item_id="+item_id);
        rd.forward(request, response);
        
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	}

}
