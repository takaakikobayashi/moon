package members.model;

import java.io.Serializable;
import java.sql.Date;

public class ReviewBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int review_id;
    private int product_id;
    private int review_star;
    private String review_title;
    private String review;
    private Date created_at;
    private Date updated_at;
    
public ReviewBean() {
    	
    	this.review_id = 0;
    	this.product_id = 0;
    	this.review_star = 0;
    	this.review_title = null;
    	this.review = null;
    	
    }
    
    public ReviewBean(int review_id, int product_id, int review_star, String review_title, String review, Date created_at, Date updated_at) {
    	
    	this.review_id = review_id;
    	this.product_id = product_id;
    	this.review_star = review_star;
    	this.review_title = review_title;
    	this.review = review;
    	this.created_at = created_at;
    	this.updated_at = updated_at;
    	
    }
    
    public int getReviewId() {
        return review_id;
    }
    public void setReviewId(int review_id) {
        this.review_id = review_id;
    }
    
    public int getProductId() {
        return product_id;
    }
    public void setProductId(int product_id) {
        this.product_id = product_id;
    }
    
    public int getReviewStar() {
        return review_star;
    }
    public void setReviewStar(int review_star) {
        this.review_star = review_star;
    }
    
    public String getReviewTitle() {
        return review_title;
    }
    public void setReviewTitle(String review_title) {
        this.review_title = review_title;
    }
    
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    
    public Date getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }
    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }

}
