package members.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDao {

	private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
    /** ユーザー名 */
    public static final String jdbcId = "root";
    /** パスワード */
    public static final String jdbcPass = "";

    public void ReviewRegister(int item_id, ReviewBean reviewBean, int member_id) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "INSERT INTO reviews (product_id, member_id, review_star, review_title, review, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, item_id);
            this.ps.setInt(2, member_id);
            this.ps.setInt(3, reviewBean.getReviewStar());
            this.ps.setString(4, reviewBean.getReviewTitle());
            this.ps.setString(5, reviewBean.getReview());
            this.ps.setDate(6, reviewBean.getCreatedAt());
            this.ps.setDate(7, reviewBean.getUpdatedAt());
            
            this.ps.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void editReview(int review_id, ReviewBean reviewBean) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "UPDATE reviews SET review_star = ?, review_title = ?, review = ?, updated_at = ? WHERE review_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, reviewBean.getReviewStar());
            this.ps.setString(2, reviewBean.getReviewTitle());
            this.ps.setString(3, reviewBean.getReview());
            this.ps.setDate(4, reviewBean.getUpdatedAt());
            this.ps.setInt(5, review_id);
            
            this.ps.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<ReviewBean> getReviewList(int item_id) {
    	
    	ArrayList<ReviewBean> review_list = new ArrayList<ReviewBean>();
    	ReviewBean review_bean = new ReviewBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT * FROM reviews WHERE product_id = ?";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, item_id);
            
            this.rs = this.ps.executeQuery();

            while (rs.next()) {
            	
            	int review_id = rs.getInt("review_id");
            	int product_id = rs.getInt("product_id");
            	int review_star = rs.getInt("review_star");
            	String review_title = rs.getString("review_title");
            	String review = rs.getString("review");
            	Date created_at = rs.getDate("created_at");
            	Date updated_at = rs.getDate("updated_at");
            	
            	review_bean = new ReviewBean(review_id,product_id,review_star,review_title,review,created_at,updated_at);
            	review_list.add(review_bean);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
            return review_list;
    }

	public int getReviewQuantity(int item_id) {
		
		int quantity = 0;
		
		try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT COUNT(*) FROM reviews WHERE product_id = ?";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, item_id);
            
            this.rs = this.ps.executeQuery();
            rs.next();
            quantity = rs.getInt(1);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
            return quantity;
	}
	
	public int getReviewSum(int item_id) {
		
		int sum = 0;
		
		try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT SUM(review_star) FROM reviews WHERE product_id = ?";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setInt(1, item_id);
            
            this.rs = this.ps.executeQuery();
            rs.next();
            sum = rs.getInt(1);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
            return sum;
	}
	
	public Boolean checkReview(String item_id, int member_id) {
    	
    	Boolean check = false;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT * FROM reviews WHERE product_id = ? AND member_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setString(1, item_id);
            this.ps.setInt(2, member_id);
            this.rs = this.ps.executeQuery();

            while (rs.next()) {
            	
            	check = true;
            	
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return check;
    }
	
	public ReviewBean getReview(int item_id, int member_id) {
		
		ReviewBean review_bean = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT * FROM reviews WHERE product_id = ? AND member_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, item_id);
            this.ps.setInt(2, member_id);
            this.rs = this.ps.executeQuery();

            while (rs.next()) {
            	
            	int review_id = rs.getInt("review_id");
            	int product_id = rs.getInt("product_id");
            	int review_star = rs.getInt("review_star");
            	String review_title = rs.getString("review_title");
            	String review = rs.getString("review");
            	Date created_at = rs.getDate("created_at");
            	Date updated_at = rs.getDate("updated_at");
            	
            	review_bean = new ReviewBean(review_id,product_id,review_star,review_title,review,created_at,updated_at);
            	
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
            return review_bean;
    }
	
	public ReviewBean getReview(int review_id) {
		
		ReviewBean review_bean = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT * FROM reviews WHERE review_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, review_id);
            this.rs = this.ps.executeQuery();

            while (rs.next()) {
            	
            	int product_id = rs.getInt("product_id");
            	int review_star = rs.getInt("review_star");
            	String review_title = rs.getString("review_title");
            	String review = rs.getString("review");
            	Date created_at = rs.getDate("created_at");
            	Date updated_at = rs.getDate("updated_at");
            	
            	review_bean = new ReviewBean(review_id,product_id,review_star,review_title,review,created_at,updated_at);
            	
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return review_bean;
    }
}
