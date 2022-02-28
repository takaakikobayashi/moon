package common.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CategoryDao {

        private Connection con = null;
        private ResultSet rs = null;
        private PreparedStatement ps = null;

        public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
        /** ユーザー名 */
        public static final String jdbcId = "root";
        /** パスワード */
        public static final String jdbcPass = "";

        public ArrayList<CategoryBean> selectcategory() {
            
            ArrayList<CategoryBean> categoryBeanList = new ArrayList<CategoryBean>();
            CategoryBean category_bean = new CategoryBean();

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	            String sql = "SELECT * FROM categories";
	            this.ps = this.con.prepareStatement(sql);
	
	            this.rs = this.ps.executeQuery();
	            
	            while (rs.next()) {
	                
	                int category_id = rs.getInt("category_id");
	                String name = rs.getString("name");
	                int is_active = rs.getInt("is_active");
	                
	                category_bean = new CategoryBean(category_id, name, is_active);
	                categoryBeanList.add(category_bean);
	           }

           } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
            return categoryBeanList;
        }
        
        public CategoryBean getName(int category_id) {
        	
        	CategoryBean category_name = new CategoryBean();
        	
        	try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	            String sql = "SELECT name FROM categories WHERE category_id = ?";
	            this.ps = this.con.prepareStatement(sql);
	
	            this.ps.setInt(1, category_id);
	            this.rs = this.ps.executeQuery();
	
	            while (rs.next()) {
	            	String name = rs.getString("name");
	            	category_name.setName(name);
	            }
            
        	} catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        	
        	return category_name;
            
        }
        
        public String getNameString(int category_id) {
        	
        	String name = null;
        	
        	try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	            String sql = "SELECT name FROM categories WHERE category_id = ?";
	            this.ps = this.con.prepareStatement(sql);
	
	            this.ps.setInt(1, category_id);
	            this.rs = this.ps.executeQuery();

	            while (rs.next()) {
	            	name = rs.getString("name");
	            }
            
        	} catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        	
        	return name;
            
        }
        
        public void editcategory(String name, int category_id) {
        	
        	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        	
        	try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

                String sql = "UPDATE categories SET name = ?, updated_at = ? WHERE category_id = ?";
	            this.ps = this.con.prepareStatement(sql);
	
	            this.ps.setString(1, name);
	            this.ps.setTimestamp(2, timestamp);
	            this.ps.setInt(3, category_id);
	            this.ps.executeUpdate();
            
        	} catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            
        }
        
        public void registerCategory(CategoryBean categorybean) {
        	
        	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        	
        	try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

                String sql = "INSERT INTO  categories (name, is_active, created_at, updated_at) VALUES (?, 1, ?, ?)";
	            this.ps = this.con.prepareStatement(sql);
	
	            this.ps.setString(1, categorybean.getName());
	            this.ps.setTimestamp(2, timestamp);
	            this.ps.setTimestamp(3, timestamp);
	            this.ps.executeUpdate();
            
        	} catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            
        }
        
        public void changetrue(int category_id) {
        	
        	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        	
        	try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

                String sql = "UPDATE categories SET is_active = 1, updated_at = ? WHERE category_id = ?";
	            this.ps = this.con.prepareStatement(sql);
	
	            this.ps.setTimestamp(1, timestamp);
	            this.ps.setInt(2, category_id);
	            this.ps.executeUpdate();
            
        	} catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            
        }
        
        public void changefalse(int category_id) {
        	
        	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        	
        	try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

                String sql = "UPDATE categories SET is_active = 2, updated_at = ? WHERE category_id = ?";
	            this.ps = this.con.prepareStatement(sql);
	
	            this.ps.setTimestamp(1, timestamp);
	            this.ps.setInt(2, category_id);
	            this.ps.executeUpdate();
            
        	} catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            
        }

}
