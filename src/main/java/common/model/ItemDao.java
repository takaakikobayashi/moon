package common.model;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ItemDao {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
    /** ユーザー名 */
    public static final String jdbcId = "root";
    /** パスワード */
    public static final String jdbcPass = "";

    public ArrayList<ItemBean> selectItem() {

        ArrayList<ItemBean> itemBeanList = new ArrayList<ItemBean>();
        ItemBean item_bean = new ItemBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT product_id, category_id, name, introduction, image_blob, price, ingredient, allergy, is_sailing FROM products";
	        this.ps = this.con.prepareStatement(sql);
	
	        this.rs = this.ps.executeQuery();
	
	        while (rs.next()) {
	            
	            int product_id = rs.getInt("product_id");
	            int category_id = rs.getInt("category_id");
	            String item_name = rs.getString("name");
	            String introduction = rs.getString("introduction");
	            Blob item_image_blob = rs.getBlob("image_blob");
	            int price = rs.getInt("price");
	            String ingredient = rs.getString("ingredient");
	            String allergy = rs.getString("allergy");
	            int is_sailing = rs.getInt("is_sailing");
	            
	            item_bean = new ItemBean(product_id, category_id, item_name, introduction, item_image_blob, price, ingredient, allergy, is_sailing);
	            itemBeanList.add(item_bean);
	       }

       } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return itemBeanList;
    }
    
    public ArrayList<ItemBean> selectItem(String check_price) {

        ArrayList<ItemBean> itemBeanList = new ArrayList<ItemBean>();
        ItemBean item_bean = new ItemBean();
        int product_id = 0;
        int category_id = 0;
        String item_name = null;
        String introduction = null;
        Blob item_image_blob = null;
        int price = 0;
        String ingredient = null;
        String allergy = null;
        int is_sailing = 0;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            if (check_price.equals("under3000")) {
		        String sql = "SELECT product_id, category_id, name, introduction, image_blob, price, ingredient, allergy, is_sailing FROM products WHERE price < 3000";
		        this.ps = this.con.prepareStatement(sql);
		        this.rs = this.ps.executeQuery();

		        while (rs.next()) {
		            
		            product_id = rs.getInt("product_id");
		            category_id = rs.getInt("category_id");
		            item_name = rs.getString("name");
		            introduction = rs.getString("introduction");
		            item_image_blob = rs.getBlob("image_blob");
		            price = rs.getInt("price");
		            ingredient = rs.getString("ingredient");
		            allergy = rs.getString("allergy");
		            is_sailing = rs.getInt("is_sailing");            
		            item_bean = new ItemBean(product_id, category_id, item_name, introduction, item_image_blob, price, ingredient, allergy, is_sailing);
		            itemBeanList.add(item_bean);
		       }
            } else if (check_price.equals("3000")) {
            	String sql = "SELECT product_id, category_id, name, introduction, image_blob, price, ingredient, allergy, is_sailing FROM products WHERE price >= 3000 AND price < 4000";
            	this.ps = this.con.prepareStatement(sql);
            	this.rs = this.ps.executeQuery();

		        while (rs.next()) {
		            
		        	product_id = rs.getInt("product_id");
		            category_id = rs.getInt("category_id");
		            item_name = rs.getString("name");
		            introduction = rs.getString("introduction");
		            item_image_blob = rs.getBlob("image_blob");
		            price = rs.getInt("price");
		            ingredient = rs.getString("ingredient");
		            allergy = rs.getString("allergy");
		            is_sailing = rs.getInt("is_sailing");
		            
		            item_bean = new ItemBean(product_id, category_id, item_name, introduction, item_image_blob, price, ingredient, allergy, is_sailing);
		            itemBeanList.add(item_bean);
		       }
            } else if (check_price.equals("4000")) {
            	String sql = "SELECT product_id, category_id, name, introduction, image_blob, price, ingredient, allergy, is_sailing FROM products WHERE price >= 4000 AND price < 5000";
            	this.ps = this.con.prepareStatement(sql);
            	this.rs = this.ps.executeQuery();

		        while (rs.next()) {
		            
		        	product_id = rs.getInt("product_id");
		            category_id = rs.getInt("category_id");
		            item_name = rs.getString("name");
		            introduction = rs.getString("introduction");
		            item_image_blob = rs.getBlob("image_blob");
		            price = rs.getInt("price");
		            ingredient = rs.getString("ingredient");
		            allergy = rs.getString("allergy");
		            is_sailing = rs.getInt("is_sailing");
		            
		            item_bean = new ItemBean(product_id, category_id, item_name, introduction, item_image_blob, price, ingredient, allergy, is_sailing);
		            itemBeanList.add(item_bean);
		       }
            } else if (check_price.equals("over5000")) {
            	String sql = "SELECT product_id, category_id, name, introduction, image_blob, price, ingredient, allergy, is_sailing FROM products WHERE price >= 5000";
            	this.ps = this.con.prepareStatement(sql);
            	this.rs = this.ps.executeQuery();

		        while (rs.next()) {
		            
		        	product_id = rs.getInt("product_id");
		            category_id = rs.getInt("category_id");
		            item_name = rs.getString("name");
		            introduction = rs.getString("introduction");
		            item_image_blob = rs.getBlob("image_blob");
		            price = rs.getInt("price");
		            ingredient = rs.getString("ingredient");
		            allergy = rs.getString("allergy");
		            is_sailing = rs.getInt("is_sailing");
		            
		            item_bean = new ItemBean(product_id, category_id, item_name, introduction, item_image_blob, price, ingredient, allergy, is_sailing);
		            itemBeanList.add(item_bean);
		       }
            }

       } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return itemBeanList;
    }

    public ItemBean selectItem(int item_id) {

        ItemBean item_bean = new ItemBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT product_id, category_id, name, introduction, image_blob, price, ingredient, allergy, is_sailing FROM products WHERE product_id = ?";
	        this.ps = this.con.prepareStatement(sql);
	
	        this.ps.setInt(1, item_id);
	        this.rs = this.ps.executeQuery();
	
	        if (rs.next()) {
	            item_bean.setProductId(rs.getInt("product_id"));
	            item_bean.setCategoryId(rs.getInt("category_id"));
	            item_bean.setName(rs.getString("name"));
	            item_bean.setIntroduction(rs.getString("introduction"));
	            item_bean.setImageBlob(rs.getBlob("image_blob"));
	            item_bean.setPrice(rs.getInt("price"));
	            item_bean.setIngredient(rs.getString("ingredient"));
	            item_bean.setAllergy(rs.getString("allergy"));
	            item_bean.setIsSailing(rs.getInt("is_sailing"));
	        }
        } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return null;
        }
        return item_bean;
    }
    
    public ItemBean categoryItem(int category_id) {

        ItemBean item_bean = new ItemBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT product_id, category_id, name, introduction, image_blob, price, ingredient, allergy, is_sailing FROM products WHERE category_id = ?";
	        this.ps = this.con.prepareStatement(sql);
	
	        this.ps.setInt(1, category_id);
	        this.rs = this.ps.executeQuery();
	
	        if (rs.next()) {
	            item_bean.setProductId(rs.getInt("product_id"));
	            item_bean.setCategoryId(rs.getInt("category_id"));
	            item_bean.setName(rs.getString("name"));
	            item_bean.setIntroduction(rs.getString("introduction"));
	            item_bean.setImageBlob(rs.getBlob("image_blob"));
	            item_bean.setPrice(rs.getInt("price"));
	            item_bean.setIngredient(rs.getString("ingredient"));
	            item_bean.setAllergy(rs.getString("allergy"));
	            item_bean.setIsSailing(rs.getInt("is_sailing"));
	        }
        } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return null;
        }
        return item_bean;
    }
    
    public ArrayList<ItemBean> selectCategoryItem(int category_id) {

        ArrayList<ItemBean> itemCategoryList = new ArrayList<ItemBean>();
        ItemBean item_category_bean = new ItemBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT product_id, category_id, name, introduction, image_blob, price, ingredient, allergy, is_sailing FROM products WHERE category_id = ?";
	        this.ps = this.con.prepareStatement(sql);
	
	        this.ps.setInt(1, category_id);
	        this.rs = this.ps.executeQuery();
	
	        while (rs.next()) {
	            
	            int product_id = rs.getInt("product_id");
	            int list_category_id = rs.getInt("category_id");
	            String item_name = rs.getString("name");
	            String introduction = rs.getString("introduction");
	            Blob item_image_blob = rs.getBlob("image_blob");
	            int price = rs.getInt("price");
	            String ingredient = rs.getString("ingredient");
	            String allergy = rs.getString("allergy");
	            int is_sailing = rs.getInt("is_sailing");
	            
	            item_category_bean = new ItemBean(product_id, list_category_id, item_name, introduction, item_image_blob, price, ingredient, allergy, is_sailing);
	            itemCategoryList.add(item_category_bean);
	       }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return itemCategoryList;
    }
    
    public ItemBean getItemName(int product_id) {
    	
    	ItemBean itemDetail_bean = new ItemBean();
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT name FROM products WHERE product_id = ?";
	        this.ps = this.con.prepareStatement(sql);
	
	        this.ps.setInt(1, product_id);
	        this.rs = this.ps.executeQuery();
	
	        while (rs.next()) {
	        	itemDetail_bean.setName(rs.getString("name"));
	       }

    	} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return itemDetail_bean;
    }
    
    public ArrayList<ItemBean> getSearchAllItem() {
    	
    	ItemBean itemDetail_bean = new ItemBean();
    	ArrayList<ItemBean> all_itemList = new ArrayList<ItemBean>();
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT * FROM products";
	        this.ps = this.con.prepareStatement(sql);
	        this.rs = this.ps.executeQuery();
	
	        while (rs.next()) {
	        	int product_id = rs.getInt("product_id");
	        	int category_id = rs.getInt("category_id");
	        	String name = rs.getString("name");
	        	Blob image_blob = rs.getBlob("image_blob");
	        	int price = rs.getInt("price");
	        	int is_sailing = rs.getInt("is_sailing");
	        	
	        	itemDetail_bean = new ItemBean(product_id, category_id, name, image_blob, price, is_sailing);
	        	all_itemList.add(itemDetail_bean);
	       }

    	} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return all_itemList;
    }
    
    public void uploadItem(String name,int category_id, String introduction, byte[] byteImage, int price, String ingredient, String allergy) {
    	
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "INSERT INTO products (category_id, name, introduction, image_blob, price, ingredient, allergy, is_sailing, created_at, updated_at) VALUES (?,?,?,?,?,?,?,1,?,?)";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, category_id);
            this.ps.setString(2, name);
            this.ps.setString(3, introduction);
            this.ps.setBinaryStream(4, new ByteArrayInputStream(byteImage));
            this.ps.setInt(5, price);
            this.ps.setString(6, ingredient);
            this.ps.setString(7, allergy);
            this.ps.setTimestamp(8, timestamp);
            this.ps.setTimestamp(9, timestamp);
            this.ps.executeUpdate();
            
    	} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void editItem(int product_id, String name, int category_id, String introduction, byte[] byteImage, int price, String ingredient, String allergy, int is_sailing) {
    	
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "UPDATE products SET category_id = ?, name = ?, introduction = ?, image_blob = ?, price = ?, ingredient = ?, allergy = ?, is_sailing = ?, created_at = ?, updated_at = ? WHERE product_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, category_id);
            this.ps.setString(2, name);
            this.ps.setString(3, introduction);
            this.ps.setBinaryStream(4, new ByteArrayInputStream(byteImage));
            this.ps.setInt(5, price);
            this.ps.setString(6, ingredient);
            this.ps.setString(7, allergy);
            this.ps.setInt(8, is_sailing);
            this.ps.setTimestamp(9, timestamp);
            this.ps.setTimestamp(10, timestamp);
            this.ps.setInt(11, product_id);
            this.ps.executeUpdate();
            
    	} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public byte[] getImageByte(int item_id) {
    	
    	byte[] bytes = null;
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT image_blob FROM products WHERE product_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, item_id);
            this.rs = this.ps.executeQuery();
            
            while(rs.next()){
            
            Blob blob = rs.getBlob("image_blob");
            int blobLength = (int) blob.length();  
            bytes = blob.getBytes(1, blobLength);
            blob.free();
            
            }
            
    	} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    	
    	return bytes;
    	
    }

    public void close() {
        try {
            // データベースとの接続を解除する
            if (this.con != null) {
                this.con.close();
            }
            if (this.ps != null) {
                this.ps.close();
            }
            if (this.rs != null) {
                this.rs.close();
            }
        } catch (SQLException se) {
            // データベースとの接続解除に失敗した場合
            se.printStackTrace();
        }
    }
}
