package members.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class OrderDetailDao {
	
	private Connection con = null;
	private ResultSet rs = null;
    private PreparedStatement ps = null;

    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/moon";
    /** ユーザー名 */
    public static final String jdbcId = "root";
    /** パスワード */
    public static final String jdbcPass = "";
    
    public void confirmOrderDetail(int order_id, int order_product_id, int order_product_amount, int order_product_price) {
    	
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
    	try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	        String sql = "INSERT INTO order_details (order_id, product_id, amount, price, production_status, created_at, updated_at) VALUES (?,?,?,?,1,?,?)";
	        this.ps = this.con.prepareStatement(sql);
	        
	        this.ps.setInt(1, order_id);
	        this.ps.setInt(2, order_product_id);
	        this.ps.setInt(3, order_product_amount);
	        this.ps.setInt(4, order_product_price);
	        this.ps.setTimestamp(5, timestamp);
            this.ps.setTimestamp(6, timestamp);
	        this.ps.executeUpdate();
        
    	 } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
         }

    }
    
    public ArrayList<OrderDetailBean> selectOrderDetail(int order_id) {

    	ArrayList<OrderDetailBean> orderDetail_list = new ArrayList<OrderDetailBean>();
    	OrderDetailBean orderDetail_bean = new OrderDetailBean();

        try {

           Class.forName("com.mysql.cj.jdbc.Driver");
           this.con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass);

	       String sql = "SELECT order_id, product_id, amount, price, production_status, created_at, updated_at FROM order_details WHERE order_id = ?";
	       this.ps = this.con.prepareStatement(sql);
	
	       this.ps.setInt(1, order_id);
	       this.rs = this.ps.executeQuery();
	
	       if (rs.next()) {
	    	   int product_id = rs.getInt("product_id");
	           int amount = rs.getInt("amount");
	           int price = rs.getInt("price");
	           int production_status = rs.getInt("production_status");
	           Date created_at = rs.getDate("created_at");
	           Date updated_at = rs.getDate("updated_at");
	           
	           orderDetail_bean = new OrderDetailBean(order_id, product_id, amount, price, production_status, created_at, updated_at);
	           orderDetail_list.add(orderDetail_bean);
	       }
        } catch (SQLException | ClassNotFoundException e) {
    	   e.printStackTrace();
    	   return null;
        }
        return orderDetail_list;
   }
}
