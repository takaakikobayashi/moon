package members.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDao {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
    /** ユーザー名 */
    public static final String jdbcId = "root";
    /** パスワード */
    public static final String jdbcPass = "";

    public int confirmOrder(int member_id,String first_name,String last_name,String postal_code,String address1,String address2,String address3,String mail,String phone_number,int total_price,int postage,int payment,int point,String remarks) {

        int autoIncrementKey = 0;
        Date timestamp = new Date(System.currentTimeMillis());

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "INSERT INTO orders (member_id, first_name,last_name,postal_code,address1,address2,address3,mail,phone_number,total_price,postage,payment,point,remarks,order_status,created_at,updated_at) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,?,?)";
            this.ps = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if (member_id != 0) {
            this.ps.setInt(1, member_id);
            } else {
            	this.ps.setString(1, null);
            }
            this.ps.setString(2, first_name);
            this.ps.setString(3, last_name);
            this.ps.setString(4, postal_code);
            this.ps.setString(5, address1);
            this.ps.setString(6, address2);
            this.ps.setString(7, address3);
            this.ps.setString(8, mail);
            this.ps.setString(9, phone_number);
            this.ps.setInt(10, total_price);
            this.ps.setInt(11, postage);
            this.ps.setInt(12, payment);
            this.ps.setInt(13, point);
            this.ps.setString(14, remarks);
            this.ps.setDate(15, timestamp);
            this.ps.setDate(16, timestamp);
            this.ps.executeUpdate();
            
            this.rs = this.ps.getGeneratedKeys();
            
            if(rs.next()){
                autoIncrementKey = rs.getInt(1);
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return autoIncrementKey;
        
  }
    
    public ArrayList<OrderBean> getOrderList() {
    	
    	ArrayList<OrderBean> order_list = new ArrayList<OrderBean>();
    	OrderBean order_bean = new OrderBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT * FROM orders INNER JOIN order_details ON orders.order_id = order_details.order_id";
            this.ps = this.con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();

            while (rs.next()) {
            	
            	int order_id = rs.getInt("order_id");
            	int member_id = rs.getInt("member_id");
            	String first_name = rs.getString("first_name");
            	String last_name = rs.getString("last_name");
            	String mail = rs.getString("mail");
            	String postal_code = rs.getString("postal_code");
            	String address1 = rs.getString("address1");
            	String address2 = rs.getString("address2");
            	String address3 = rs.getString("address3");
            	String phone_number = rs.getString("phone_number");
            	int total_price = rs.getInt("total_price");
            	int postage = rs.getInt("postage");
            	int payment = rs.getInt("payment");
            	int point = rs.getInt("point");
            	String remarks = rs.getString("remarks");
            	int product_id = rs.getInt("product_id");
            	int price = rs.getInt("price");
            	Date created_at = rs.getDate("created_at");
            	int order_status = rs.getInt("order_status");
            	int production_status = rs.getInt("production_status");
            	
            	order_bean = new OrderBean(order_id,member_id,first_name,last_name,mail,postal_code,address1,address2,address3,phone_number,total_price,postage,payment,point,remarks,product_id,price,created_at,order_status,production_status);
            	order_list.add(order_bean);
            	
          }
      } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
          return null;
      }
      return order_list;
    }
    
    public Boolean checkOrder(String item_id, int member_id) {
    	
    	Boolean check = false;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT * FROM orders INNER JOIN order_details ON orders.order_id = order_details.order_id WHERE order_details.product_id = ? AND orders.member_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setString(1, item_id);
            this.ps.setInt(2, member_id);
            this.rs = this.ps.executeQuery();

            if (rs.next()) {
            	
            	check = true;
            	
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return check;
    }
    
    public OrderBean getName(int order_id) {
    	
    	OrderBean order_bean = new OrderBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT first_name, last_name FROM orders WHERE order_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, order_id);
            this.rs = this.ps.executeQuery();

            while (rs.next()) {
            	order_bean.setFirstName(rs.getString("first_name"));
            	order_bean.setLastName(rs.getString("last_name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return order_bean;
    }
    
    public OrderBean getAddress(int order_id) {
    	
    	OrderBean order_bean = new OrderBean();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

            String sql = "SELECT postal_code, address1, address2, address3 FROM orders WHERE order_id = ?";
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, order_id);
            this.rs = this.ps.executeQuery();

            while (rs.next()) {
            	order_bean.setPostalCode(rs.getString("postal_code"));
            	order_bean.setAddress1(rs.getString("address1"));
            	order_bean.setAddress2(rs.getString("address2"));
            	order_bean.setAddress3(rs.getString("address3"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return order_bean;
    }
    
    public ArrayList<OrderBean> selectOrder(int member_id) {

    	ArrayList<OrderBean> order_list = new ArrayList<OrderBean>();
    	OrderBean order_bean = new OrderBean();

        try {

           Class.forName("com.mysql.cj.jdbc.Driver");
           this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	       String sql = "SELECT first_name, last_name, postal_code, address1, address2, address3, mail, phone_number, total_price, postage, payment, point, remarks, order_status, created_at, updated_at FROM orders WHERE member_id = ?";
	       this.ps = this.con.prepareStatement(sql);
	
	       this.ps.setInt(1, member_id);
	       this.rs = this.ps.executeQuery();

	       if (rs.next()) {
	    	   String first_name = rs.getString("first_name");
	    	   String last_name = rs.getString("last_name");
	    	   String postal_code = rs.getString("postal_code");
	    	   String address1 = rs.getString("address1");
	    	   String address2 = rs.getString("address2");
	    	   String address3 = rs.getString("address3");
	    	   String mail = rs.getString("mail");
	    	   String phone_number = rs.getString("phone_number");
	           int total_price = rs.getInt("total_price");
	           int postage = rs.getInt("postage");
	           int payment = rs.getInt("payment");
	           int point = rs.getInt("point");
	           String remarks = rs.getString("remarks");
	           int order_status = rs.getInt("order_status");
	           Date created_at = rs.getDate("created_at");
	           Date updated_at = rs.getDate("updated_at");
	           
	           order_bean = new OrderBean(first_name, last_name, postal_code, address1, address2, address3, mail, phone_number, total_price, postage, payment, point, remarks, order_status, created_at, updated_at);
	           order_list.add(order_bean);
	       }
       } catch (SQLException | ClassNotFoundException e) {
    	   e.printStackTrace();
    	   return null;
       }
       return order_list;
   }
    
    public ArrayList<OrderBean> getEarningPrice() {
    	
    	int earnings = 0;
    	OrderBean each_price = new OrderBean();
    	ArrayList<OrderBean> earningsList = new ArrayList<OrderBean>();
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "SELECT total_price, created_at FROM orders";
	        this.ps = this.con.prepareStatement(sql);
	        this.rs = this.ps.executeQuery();
        
	        while (rs.next()) {
	        	int total_price = rs.getInt("total_price");
	        	Date created_at = rs.getDate("created_at");
	        	each_price = new OrderBean(total_price,created_at);
	        	earningsList.add(each_price);
	        	earnings += total_price;
	        }
	        
    	} catch (SQLException | ClassNotFoundException e) {
    	       e.printStackTrace();
    	}
    	return earningsList;
    }
    
    public void updateOrderStatus(int order_status, int order_id) {
    	
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql1 = "UPDATE order_details SET production_status = ? WHERE order_id = ?";
	        this.ps = this.con.prepareStatement(sql1);
            
            this.ps.setInt(1, order_status);
            this.ps.setInt(2, order_id);
            this.ps.executeUpdate();
            
            String sql2 = "UPDATE orders SET order_status = ? WHERE order_id = ?";
	        this.ps = this.con.prepareStatement(sql2);
            
            this.ps.setInt(1, order_status-1);
            this.ps.setInt(2, order_id);
            this.ps.executeUpdate();
	        
    	} catch (SQLException | ClassNotFoundException e) {
    	    e.printStackTrace();
    	}
    	
    }

    public void close() {
        try {
            if (this.con != null) {
                this.con.close();
            }
            if (this.ps != null) {
                this.ps.close();
            }
            if (this.rs != null) {
                this.rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
