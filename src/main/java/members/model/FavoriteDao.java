package members.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.model.ItemBean;
import common.model.ItemDao;

public class FavoriteDao {
	
	private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
    /** ユーザー名 */
    public static final String jdbcId = "root";
    /** パスワード */
    public static final String jdbcPass = "";
    
    public void registerFavorite(int member_id, int item_id) {
    	
    	Date timestamp = new Date(System.currentTimeMillis());

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);
            
            String select_sql = "SELECT * FROM favorites WHERE member_id = ? AND product_id = ?";
            this.ps = this.con.prepareStatement(select_sql);
            
            this.ps.setInt(1, member_id);
            this.ps.setInt(2, item_id);
            this.rs = this.ps.executeQuery();
            
            if (rs.next()) {

            	String delete_sql = "DELETE FROM favorites WHERE member_id = ? AND product_id = ?";
                this.ps = this.con.prepareStatement(delete_sql);

                this.ps.setInt(1, member_id);
                this.ps.setInt(2, item_id);
                this.ps.executeUpdate();
		        
            } else {
            	
            	String insert_sql = "INSERT INTO favorites (member_id, product_id, created_at, updated_at) VALUES (?, ?, ?, ?)";
		        this.ps = this.con.prepareStatement(insert_sql);
		
		        this.ps.setInt(1, member_id);
		        this.ps.setInt(2, item_id);
		        this.ps.setDate(3, timestamp);
		        this.ps.setDate(4, timestamp);
		        this.ps.executeUpdate();
            
            }

        } catch (SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
        }
    }
    
    public Boolean checkFavorite(int member_id, int item_id) {
    	
    	Boolean favorite = false;
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT * FROM favorites WHERE member_id = ? AND product_id = ?";
	        this.ps = this.con.prepareStatement(sql);
	
	        this.ps.setInt(1, member_id);
	        this.ps.setInt(2, item_id);
	        this.rs = this.ps.executeQuery();
        
	        if (rs.next()) {
	        	
	        	favorite = true;
	        	
	        } else {
	        	
	        	favorite = false;
	        	
	        }

        } catch (SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
        }
    	
    	return favorite;
    	
    }
    
    public void removeFavorite(int member_id, int item_id) {
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "DELETE FROM favorites WHERE member_id = ? AND product_id = ?";
	        this.ps = this.con.prepareStatement(sql);
	
	        this.ps.setInt(1, member_id);
	        this.ps.setInt(2, item_id);
	        this.ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
        }
    	
    }
    
    public ArrayList<ItemBean> myFavorite(int member_id) {
    	
    	ItemBean item_bean = new ItemBean();
    	ArrayList<ItemBean> itemBeanList = new ArrayList<ItemBean>();
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT * FROM favorites WHERE member_id = ?";
	        this.ps = this.con.prepareStatement(sql);
	
	        this.ps.setInt(1, member_id);
	        this.rs = this.ps.executeQuery();
        
	        while (rs.next()) {
	        	
	        	int product_id = rs.getInt("product_id");
	            
	            ItemDao itemDao = new ItemDao();
	            item_bean = itemDao.selectItem(product_id);
	            itemBeanList.add(item_bean);
	        	
	        }

        } catch (SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
        }
    	
    	return itemBeanList;
    	
    }

}
